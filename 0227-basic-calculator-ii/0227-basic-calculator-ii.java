class Solution {
    public int calculate(String s) {
        if(s==null || s.isEmpty()) return 0;
        Deque<Integer> st = new ArrayDeque<>();
        int currentNum = 0;
        int operation = '+';
        for(int i = 0 ; i < s.length() ; i ++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                currentNum = (currentNum * 10) + (ch - '0');
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() -1){
                switch(operation){
                    case '+':
                    st.push(currentNum);
                    break;

                    case '-':
                    st.push(-currentNum);
                    break;

                    case '*':
                    st.push(st.pop() * currentNum);
                    break;

                    case '/':
                    st.push(st.pop() / currentNum);
                    break;
                }
                operation = ch;
                currentNum = 0;
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}