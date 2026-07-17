class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0 ;
        int deepCount = 0 ;
        for(char c : s.toCharArray()){
            if(c == '('){
                deepCount++;
                maxDepth = Math.max(maxDepth,deepCount);
            }else if (c == ')'){
                deepCount--;
            }
        }
        return maxDepth;
    }
}