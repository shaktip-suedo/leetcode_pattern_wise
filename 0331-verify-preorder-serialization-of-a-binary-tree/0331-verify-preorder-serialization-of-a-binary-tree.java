class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int s = 1;
        for(String n : arr){
            s--;
            if(s<0){
                return false;
            }
            if(!n.equals("#")){
                s += 2;
            }
        }
        return s == 0;
    }
}