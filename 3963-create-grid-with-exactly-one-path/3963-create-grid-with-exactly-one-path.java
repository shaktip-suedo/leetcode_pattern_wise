class Solution {
    public String[] createGrid(int m, int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '#');

            if (i == 0) {
                Arrays.fill(row, '.');
            } else {
                row[n - 1] = '.';
            }
            ans.add(new String(row));
        }
        return ans.toArray(new String[0]);
    }
}