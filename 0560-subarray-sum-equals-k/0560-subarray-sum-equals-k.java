class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        for(int i = 0 ;  i < nums.length ; i++){
            sum += nums[i];
            int sumK = sum - k;
            if(map.containsKey(sumK)){
                count += map.get(sumK);
            }
                map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count ; 
    }
}