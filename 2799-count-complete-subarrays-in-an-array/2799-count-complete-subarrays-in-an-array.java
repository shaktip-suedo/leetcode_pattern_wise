class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> m = new HashSet<>();
        int count = 0 ;
        for(int num : nums){
            m.add(num);
        }
        for(int i=0 ; i < nums.length ; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i;j<nums.length ; j++){
                set.add(nums[j]);
                if(set.size() == m.size()){
                    count += nums.length - j;
                    break;
                }

            }
        }
return count;
    }
}