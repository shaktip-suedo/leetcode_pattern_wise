class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = 0 ; i < temperatures.length ; i ++){
            int currentTemp = temperatures[i];
            while(!s.isEmpty() && currentTemp > temperatures[s.peek()]){
                int prev= s.pop();
                result[prev] = i - prev;
            }
            s.push(i);
        }
return result;
    }
}