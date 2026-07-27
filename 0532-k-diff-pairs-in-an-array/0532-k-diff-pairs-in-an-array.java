class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0 ;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int uniquePairs = 0;
        for(int i =0 ; i < nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = nums[i] + k;
            int left = i +1;
            int right = n -1;

            while(left <= right){
                int mid= left+ (right-left)/2;
                if(nums[mid] == target){
                    uniquePairs++;
                    break;
                }else if(nums[mid] < target){
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }
        }
        return uniquePairs;
    }
}