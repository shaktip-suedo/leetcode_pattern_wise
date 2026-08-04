class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1 ; i< nums.length ; i++){
            for(int j = nums[i-1]+1;j<nums[i];j++ ){
                arr.add(j);
            }
        }
        return arr;
    }
}