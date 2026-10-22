class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        boolean isInc = true;
        boolean isDec = true;
        int idx0 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
            }
            if ((nums[(i + 1) % n] - nums[i] + n) % n != 1) {
                isInc = false;
            }
            if ((nums[i] - nums[(i + 1) % n] + n) % n != 1) {
                isDec = false;
            }
        }

        if (isInc) {
            if (idx0 == 0) return 0;
            return Math.min(idx0, n - idx0 + 2);
        }

        if (isDec) {
            int cand1 = n - idx0;
            int cand2 = (idx0 + 1) % n + 1;
            return Math.min(cand1, cand2);
        }

        return -1;
    }
}