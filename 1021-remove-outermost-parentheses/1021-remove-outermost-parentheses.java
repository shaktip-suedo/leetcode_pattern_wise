class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int b = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (b > 0) {
                    sb.append(ch);
                }
                b++;
            } else {
                b--;
                if (b > 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}