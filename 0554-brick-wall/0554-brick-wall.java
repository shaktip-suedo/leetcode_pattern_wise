class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxCount = 0 ;
        for(List<Integer> row : wall){
            int position = 0 ;

            for(int i = 0 ; i < row.size()-1;i++){
                position += row.get(i);

                map.put(position,map.getOrDefault(position,0)+1);
                maxCount = Math.max(maxCount, map.get(position));
            }
        }
        return wall.size() - maxCount;
    }
}