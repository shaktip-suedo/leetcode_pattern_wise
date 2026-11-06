import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        // Sort queries and logs by time
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] ans = new int[m];
        HashMap<Integer, Integer> serverCounts = new HashMap<>();
        
        int logIdx = 0;
        int windowStart = 0;
        
        for (int i = 0; i < m; i++) {
            int qTime = sortedQueries[i][0];
            int qIdx = sortedQueries[i][1];
            int leftBound = qTime - x;
            int rightBound = qTime;
            
            // Add logs that fall within or before the right bound
            while (logIdx < logs.length && logs[logIdx][1] <= rightBound) {
                int serverId = logs[logIdx][0];
                serverCounts.put(serverId, serverCounts.getOrDefault(serverId, 0) + 1);
                logIdx++;
            }
            
            // Remove logs that fall outside the left bound of the sliding window
            while (windowStart < logIdx && logs[windowStart][1] < leftBound) {
                int serverId = logs[windowStart][0];
                int count = serverCounts.get(serverId);
                if (count == 1) {
                    serverCounts.remove(serverId);
                } else {
                    serverCounts.put(serverId, count - 1);
                }
                windowStart++;
            }
            
            // Servers with zero requests = total servers - servers with at least one request
            ans[qIdx] = n - serverCounts.size();
        }
        
        return ans;
    }
}