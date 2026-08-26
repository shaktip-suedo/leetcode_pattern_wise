class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxLight = 0;
        for(int light : lights){
            maxLight = Math.max(maxLight,light);
        }
        int maxWait = 0;
        for(int time: arrivalTime){
            int r=  time % period;
            if(r>=maxLight){
                maxWait=Math.max(maxWait,period-r);
            }
        }
        return maxWait;
    }
}