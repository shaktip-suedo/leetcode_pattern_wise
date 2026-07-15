class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long val = 1;
        for(int start = 0; start <= rowIndex;start++){
            list.add((int) val);
            val = val*(rowIndex - start)/(start+1);
        }
        return list;
    }
}