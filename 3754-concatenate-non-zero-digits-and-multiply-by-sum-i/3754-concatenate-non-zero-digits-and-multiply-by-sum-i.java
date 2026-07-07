class Solution {
    public long sumAndMultiply(int n) {

        int rev = 0;
        while (n > 0) {
            int digit = n % 10;

            if (digit != 0) {
                rev = rev * 10 + digit;
            }

            n /= 10;
        }

        int ans = 0;
        while (rev > 0) {
            ans = ans * 10 + rev % 10;
            rev /= 10;
        }

        int sum = digitSum(ans);

        return 1L * sum * ans;
    }

    public int digitSum(int ans) {
        int sum = 0;

        while (ans > 0) {
            sum += ans % 10;
            ans /= 10;
        }

        return sum;
    }
}