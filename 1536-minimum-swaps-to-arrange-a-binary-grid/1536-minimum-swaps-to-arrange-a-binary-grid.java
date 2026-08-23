class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] tZ = new int[n];
        for(int i = 0; i<n;i++){
            int count = 0;
            for(int j = n-1;j>=0;j--){
                if(grid[i][j] == 0){
                    count++;
                }else{
                    break;
                }
            }
            tZ[i] = count;
        }
        int tS = 0;
        for(int i = 0 ; i < n ; i++){
            int t = n-i-1;
        int j = i;
        while(j<n && tZ[j] < t){
                j++;
            
        }
        if(j==n){
            return -1;
        }
    for(int k = i;k<j;){
        int tem =tZ[j];
        tZ[j] = tZ[j-1];
        tZ[j-1] = tem;
        tS++;
        j--;
    }

        }
return tS;
    }
}
