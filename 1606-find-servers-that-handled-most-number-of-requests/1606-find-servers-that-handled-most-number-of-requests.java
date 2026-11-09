class Solution {
    public List<Integer> busiestServers(int k, int[] a, int[] load) {

        List<Integer> ans = new ArrayList<>();

        int[] cnt = new int[k];

        // Available servers
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // {finishTime, serverNumber}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (x, y) -> Long.compare(x[0], y[0])
        );

        for (int i = 0; i < a.length; i++) {

            // Free servers that have completed their work
            while (!busy.isEmpty() && busy.peek()[0] <= a[i]) {
                long[] server = busy.poll();
                available.add((int) server[1]);
            }

            // No server available -> drop request
            if (available.isEmpty()) {
                continue;
            }

            int preferred = i % k;

            // Find first available server >= preferred
            Integer server = available.ceiling(preferred);

            // If not found, wrap around
            if (server == null) {
                server = available.first();
            }

            // Assign request
            available.remove(server);

            long finishTime = (long) a[i] + load[i];

            busy.add(new long[]{finishTime, server});

            cnt[server]++;
        }

        // Find maximum
        int max = 0;

        for (int i = 0; i < k; i++) {
            max = Math.max(max, cnt[i]);
        }

        // Collect answer
        for (int i = 0; i < k; i++) {
            if (cnt[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}