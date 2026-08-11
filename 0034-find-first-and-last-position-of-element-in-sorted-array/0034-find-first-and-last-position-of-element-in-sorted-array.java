class Solution {
    public int firstPos (int[] nums , int target){
        int left = 0 ;
        int right = nums.length - 1;

        int firstIndex = -1 ;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                firstIndex = mid;
                right = mid - 1;
            }else if ( target > nums[mid]){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            
        }
        return firstIndex;
    }
       public int lastPos(int[] nums , int target){
        int left = 0 ;
        int right = nums.length - 1;

        int lastIndex = -1 ;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                lastIndex = mid;
                left = mid + 1;
            }else if ( target > nums[mid]){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
           
        }
         return lastIndex;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums ==  null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int first = firstPos(nums ,target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = lastPos(nums ,target);
        return new int[] {first , last};
        
    }
}