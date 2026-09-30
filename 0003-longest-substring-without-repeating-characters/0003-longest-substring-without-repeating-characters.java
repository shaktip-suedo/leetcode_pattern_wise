import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;

        Set<Character> res = new HashSet<>();

        while (j < s.length()) {

            char c = s.charAt(j);

            while (res.contains(c)) {
                res.remove(s.charAt(i));
                i++;
            }

            res.add(c);

            max = Math.max(max, j - i + 1);

            j++;
        }

        return max;
    }
}