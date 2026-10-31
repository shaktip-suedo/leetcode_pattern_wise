class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            rightSum -= nums[i]; // current element ko right side se hata diya

            ans[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i]; // current element ko left side me add kar diya
        }

        return ans;
    }
}