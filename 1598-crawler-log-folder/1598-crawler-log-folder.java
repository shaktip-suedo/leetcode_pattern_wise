class Solution {
    public int minOperations(String[] logs) {
      Stack<String> st = new Stack<>();
      for(String l : logs){
        if(l.equals("../")){
            if(!st.isEmpty()){
                st.pop();
            }
        }else if(l.equals("./")){
            continue;
        }else{
            st.push(l);
        }
      }  
      return st.size();
    }
}