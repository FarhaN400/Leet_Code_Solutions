class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] q) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int m = q.length;
        int[][] queries = new int[m][2];

        for(int i = 0; i < m; i++) {
            queries[i][0] = q[i];
            queries[i][1] = i;
        }

        Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        int[] ans = new int[m];

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        for(int i = 0; i < m; i++) {

            int a = queries[i][0] - x;
            int b = queries[i][0];

            // Add logs within the right boundary
            while(right < logs.length && logs[right][1] <= b) {
                int id = logs[right][0];
                map.put(id, map.getOrDefault(id, 0) + 1);
                right++;
            }

            // Remove logs outside the left boundary
            while(left < right && logs[left][1] < a) {
                int id = logs[left][0];

                map.put(id, map.get(id) - 1);

                if(map.get(id) == 0) {
                    map.remove(id);
                }

                left++;
            }

            ans[queries[i][1]] = n - map.size();
        }

        return ans;
    }
}
