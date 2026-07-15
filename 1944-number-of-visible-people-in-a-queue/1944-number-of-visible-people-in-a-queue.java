class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        int h = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i  = h -1 ; i >= 0 ; i--){
            while(!st.isEmpty() && heights[i] > st.peek()){
                ans[i]++;
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]++;

            }
            st.push(heights[i]);
        }
        return ans;
    }
}