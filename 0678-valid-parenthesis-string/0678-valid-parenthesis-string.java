class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openS = new Stack<>();
        Stack<Integer> starS = new Stack<>();

        for(int i = 0 ; i< s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                openS.push(i);
            }else if(ch=='*'){
                starS.push(i);
            }else{
                if(!openS.isEmpty()){
                    openS.pop();
                }else if(!starS.isEmpty()){
                    starS.pop();
                }else{
                    return false;
                }
            }
        }
        while(!openS.isEmpty() && !starS.isEmpty()){
            if(openS.peek() < starS.peek()){
            openS.pop();
            starS.pop();
            }else{
                return false;
            }
        }
        return openS.isEmpty();
    }
}