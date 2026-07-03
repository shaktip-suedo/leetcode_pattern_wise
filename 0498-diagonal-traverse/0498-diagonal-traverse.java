class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m*n];
        int idx = 0;

        for(int  d = 0 ; d <= m + n -2; d++){
            ArrayList<Integer> list = new ArrayList<>();
            int row = d<n?0:d-n+1;
            int col = d - row;

            while(row < m && col >= 0){
                list.add(mat[row][col]);
                row++;
                col--;
            }
            if(d % 2 ==0){
                for(int i = list.size()-1;i>=0;i--){
                    ans[idx++] = list.get(i);
                }
            }else{
                for (int num : list) {
                    ans[idx++] = num;
                }
            }

        }
        return ans;
    }
}