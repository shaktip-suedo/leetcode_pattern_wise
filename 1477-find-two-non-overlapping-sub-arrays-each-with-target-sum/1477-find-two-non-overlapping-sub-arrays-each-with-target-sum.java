class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] dp = new int[n];
        int INF = 1000000000;

        for (int i = 0; i < n; i++) {
            dp[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;
        int best = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;

                // Previous non-overlapping subarray
                if (left > 0 && dp[left - 1] != INF) {
                    ans = Math.min(ans, length + dp[left - 1]);
                }

                best = Math.min(best, length);
            }

            // Store minimum valid subarray length till current index
            if (right == 0) {
                dp[right] = best;
            } else {
                dp[right] = Math.min(dp[right - 1], best);
            }
        }

        return ans == INF ? -1 : ans;
    }
}