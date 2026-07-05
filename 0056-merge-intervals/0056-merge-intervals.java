class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1){
            return intervals;
        }
        List<int[]> l = new ArrayList<>();
        Arrays.sort(intervals , (x,y) -> Integer.compare(x[0],y[0]));
        int start = intervals[0][0];
        int end  = intervals[0][1];

        for(int i = 1 ;i< intervals.length ; i++){
            int s = intervals[i][0];
            int e = intervals[i][1];

            if(end >= s ){
                end = Math.max(end, e);
                continue;
            }
            l.add(new int[]{start,end});
            start = s ;
            end = e;
        }
        l.add(new int[]{start,end});
        return l.toArray(new int[l.size()][]);
    }
}