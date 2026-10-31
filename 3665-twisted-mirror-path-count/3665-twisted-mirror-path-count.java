class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][][] jump = new int[m][n][2][];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 2; d++) {
                    jump[i][j][d] = resolve(grid, i, j, d, m, n);
                }
            }
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                long cur = dp[i][j];
                if (j + 1 < n) {
                    int[] target = jump[i][j + 1][0];
                    if (target != null) {
                        dp[target[0]][target[1]] = (int) ((dp[target[0]][target[1]] + cur) % MOD);
                    }
                }

                // Move Down (direction 1)
                if (i + 1 < m) {
                    int[] target = jump[i + 1][j][1];
                    if (target != null) {
                        dp[target[0]][target[1]] = (int) ((dp[target[0]][target[1]] + cur) % MOD);
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int[] resolve(int[][] grid, int r, int c, int d, int m, int n) {
        int cr = r, cc = c, cd = d;

        while (cr < m && cc < n) {
            if (grid[cr][cc] == 0) {
                return new int[]{cr, cc};
            }
            // Mirror reflection:
            // Entering right (0) turns down (1), landing below: (cr + 1, cc)
            // Entering down (1) turns right (0), landing right: (cr, cc + 1)
            if (cd == 0) {
                cr = cr + 1;
                cd = 1;
            } else {
                cc = cc + 1;
                cd = 0;
            }
        }
        return null; // went out of bounds
    }
}