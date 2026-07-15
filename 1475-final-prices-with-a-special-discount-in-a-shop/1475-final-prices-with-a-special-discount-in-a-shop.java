class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < prices.length ; i++){
            while(!st.isEmpty() && prices[st.peek()]>= prices[i]){
                int diff = st.pop();
                ans[diff] = prices[diff] - prices[i];
            }
            st.push(i);
        }
            
             while (!st.isEmpty()) {
            int idx = st.pop();
            ans[idx] = prices[idx];
        }
        return ans;
    }
}