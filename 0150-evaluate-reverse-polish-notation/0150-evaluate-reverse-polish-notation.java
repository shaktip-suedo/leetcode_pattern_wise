class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();
        for(String t : tokens){
            switch(t){
                case "+" -> s.push(s.pop() + s.pop());
                case "*" -> s.push(s.pop() * s.pop());
                case "-" -> {
                    int b = s.pop(), a = s.pop() ;
                    s.push(a-b);
                }
                case "/" -> {
                    int b = s.pop(), a = s.pop() ;
                    s.push(a/b);
                }
                default -> s.push(Integer.parseInt(t));
            }

        }
        return s.pop();
    }
}