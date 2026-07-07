class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans[][] = new int[m][n];
        for(int i = 0 ; i < ans.length ; i++){
            for(int j = 0 ; j < ans[0].length ;j++){
                ans[i][j] = matrix[j][i];

            }

        }
        return ans;
    }
}