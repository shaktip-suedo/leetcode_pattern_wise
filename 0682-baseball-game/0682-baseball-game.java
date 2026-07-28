class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for(String op : operations){
            if(op.equals("+")){
                int top = s.pop();
                int newtop = top + s.peek();
                s.push(top);
                s.push(newtop);
            }else if(op.equals("D")){
                s.push(s.peek() *2);
            }else if(op.equals("C")){
                s.pop();
            }else{
                s.push(Integer.parseInt(op));
            }
        }
        int total = 0 ;
        for(int t : s){
            total += t;
        }
        return total;
    }
}