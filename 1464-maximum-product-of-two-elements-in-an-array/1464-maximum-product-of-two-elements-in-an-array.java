class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int n = arr.length;
        for(int  i = 0 ; i < nums.length ; i++){
            arr[i] = nums[i] - 1;
        }
        return arr[n-1] * arr[n-2];
    }
}