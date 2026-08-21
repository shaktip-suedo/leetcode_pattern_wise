class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int minOps = Integer.MAX_VALUE;
        char[] arr = s.toCharArray();
        for(int r = 0 ; r < n ;r++){
            int currentOps = r;
            for(int i = 0 ; i < n/2;i++){
                char c1 = arr[(r+i)%n];
                char c2 = arr[(r+n-1-i)%n];
                int diff = Math.abs(c1-c2);
                currentOps += Math.min(diff,26-diff);
            }
            minOps = Math.min(minOps,currentOps);
        }
        return minOps;
    }
}