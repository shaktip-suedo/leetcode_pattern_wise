class Solution {

    public int[][] rotateGrid(int[][] grid, int k) {

        int layers = Math.min(grid.length, grid[0].length) / 2;
        for (int s = 0; s < layers; s++) {
            int[] oneD = fillOneDfromShell(grid, s);

            rotate(oneD, k % oneD.length);

            fillShellfromoneD(grid, s, oneD);
        }

        return grid;
    }

    public int[] fillOneDfromShell(int[][] grid, int s) {

        int m = grid.length;
        int n = grid[0].length;

        int top = s;
        int left = s;
        int bottom = m - 1 - s;
        int right = n - 1 - s;

        int size = 2 * (bottom - top + right - left);
        int[] arr = new int[size];

        int idx = 0;

        for (int i = top; i <= bottom; i++)
            arr[idx++] = grid[i][left];

        for (int j = left + 1; j <= right; j++)
            arr[idx++] = grid[bottom][j];

        for (int i = bottom - 1; i >= top; i--)
            arr[idx++] = grid[i][right];

        for (int j = right - 1; j >= left + 1; j--)
            arr[idx++] = grid[top][j];

        return arr;
    }

    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k %= n;

        // Right rotation
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void fillShellfromoneD(int[][] grid, int s, int[] arr) {

        int m = grid.length;
        int n = grid[0].length;

        int top = s;
        int left = s;
        int bottom = m - 1 - s;
        int right = n - 1 - s;

        int idx = 0;

        for (int i = top; i <= bottom; i++)
            grid[i][left] = arr[idx++];

        for (int j = left + 1; j <= right; j++)
            grid[bottom][j] = arr[idx++];

        for (int i = bottom - 1; i >= top; i--)
            grid[i][right] = arr[idx++];

        for (int j = right - 1; j >= left + 1; j--)
            grid[top][j] = arr[idx++];
    }

}