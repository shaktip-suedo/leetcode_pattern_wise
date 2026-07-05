class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> m = new HashSet<>();
        int count = 0 ;
        
        for(int num : nums){
            m.add(num);
        }
        int totalDistinct = m.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for(int right = 0 ; right<nums.length; right++){
            map.put(nums[right] , map.getOrDefault(nums[right],0)+1);
            while(map.size() == totalDistinct){
                count += nums.length - right;

                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
        }

       
return count;
    }
}