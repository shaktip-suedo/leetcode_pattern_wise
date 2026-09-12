import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new int[]{
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            });
        }

        arr.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        long[][] dp = new long[n + 1][5];

        @SuppressWarnings("unchecked")
        List<Integer>[][] selected = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                selected[i][j] = new ArrayList<>();
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            int start = arr.get(i)[0];
            int end = arr.get(i)[1];
            int weight = arr.get(i)[2];
            int originalIndex = arr.get(i)[3];

            int next = binarySearch(arr, end);

            for (int k = 0; k < 5; k++) {

                // Skip interval
                dp[i][k] = dp[i + 1][k];
                selected[i][k] = new ArrayList<>(selected[i + 1][k]);

                // Take interval if less than 4 selected
                if (k < 4) {

                    long take = weight + dp[next][k + 1];

                    List<Integer> takeList =
                        new ArrayList<>(selected[next][k + 1]);

                    takeList.add(originalIndex);

                    Collections.sort(takeList);

                    if (take > dp[i][k] ||
                        (take == dp[i][k] &&
                         isLexicographicallySmaller(takeList, selected[i][k]))) {

                        dp[i][k] = take;
                        selected[i][k] = takeList;
                    }
                }
            }
        }

        Collections.sort(selected[0][0]);

        int[] ans = new int[selected[0][0].size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = selected[0][0].get(i);
        }

        return ans;
    }

    private int binarySearch(List<int[]> arr, int end) {
        int low = 0;
        int high = arr.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid)[0] > end) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isLexicographicallySmaller(
        List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}