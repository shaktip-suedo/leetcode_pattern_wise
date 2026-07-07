class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int longest = 0;
        for (int num : s) {
            if (!s.contains(num - 1)) {
                int currSum = num;
                int count = 1;
                while (s.contains(currSum + 1)) {
                    currSum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}