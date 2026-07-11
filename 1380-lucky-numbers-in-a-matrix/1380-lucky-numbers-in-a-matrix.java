class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] rowMin = new int[rows];
        int[] colMax = new int[cols];

        for (int i = 0; i < rows; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            rowMin[i] = min;
        }
        for (int j = 0; j < cols; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            colMax[j] = max;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    list.add(matrix[i][j]);
                }
            }
        }

        return list;
    }
}