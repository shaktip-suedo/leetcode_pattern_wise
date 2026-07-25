class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insert = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    insert++;
                }
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    insert++;
                    i++;
                }
            }
        }
        insert += 2 * open;
        return insert;
    }
}