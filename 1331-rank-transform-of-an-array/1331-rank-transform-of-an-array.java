class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        Map<Integer, Integer> rank = new HashMap<>();
        for (int a : sortedArr) {
            rank.putIfAbsent(a, rank.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        
        return arr;
    }
}