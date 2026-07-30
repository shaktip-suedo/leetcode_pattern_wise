class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();
        String[] parts = path.split("/");
        for(String part : parts ){
            if(part.isEmpty() || part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append("/").append(st.pollLast());
        }
        return sb.length() == 0? "/":sb.toString();
    }
}