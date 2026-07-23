class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st = new Stack<>();
        int curr = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(curr);
                curr = 0;
            }else{
                int prev = st.pop();
                curr = prev + Math.max(2*curr,1);
            }
        }
        return curr;
    }
}