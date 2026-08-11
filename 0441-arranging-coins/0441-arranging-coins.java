class Solution {
    public int arrangeCoins(int n) {
        int r = 1;
        while(r <= n){
            n = n - r;
            r++;
        }
        return r-1;
    }
}