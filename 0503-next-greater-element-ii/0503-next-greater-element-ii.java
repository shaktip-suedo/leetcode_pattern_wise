class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();

        for(int i = 0 ; i < 2 * n ; i ++){
            int c = i % n;
            while(!s.isEmpty() && nums[c] > nums[s.peek()]){
                int ans = s.pop();
                result[ans] = nums[c];
            }
            if(i < n ){
                s.push(i);
            }
        }
        return result ; 
    }
}