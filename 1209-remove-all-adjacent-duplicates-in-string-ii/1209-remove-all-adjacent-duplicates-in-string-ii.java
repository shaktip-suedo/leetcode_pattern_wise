class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> st = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0] == ch){
                st.peek()[1]++;
            }else{
                st.push(new int[] {ch ,1});
            }
            if(st.peek()[1] == k){
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            int[] top=st.removeLast();
            sb.append(String.valueOf((char)top[0]).repeat(top[1]));
        }
        return sb.toString();
    }
}