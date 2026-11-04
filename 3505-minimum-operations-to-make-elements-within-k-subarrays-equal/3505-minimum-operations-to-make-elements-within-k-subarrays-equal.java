
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    long sumLeft = 0;
    long sumRight = 0;

    int leftSize = 0;
    int rightSize = 0;

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window
        long[] cost = new long[n - x + 1];

        // Initialize first window
        for (int i = 0; i < x; i++) {
            add(nums[i]);
        }

        cost[0] = getCost();

        // Slide the window
        for (int i = x; i < n; i++) {

            remove(nums[i - x]);
            add(nums[i]);

            cost[i - x + 1] = getCost();
        }

        // Step 2: DP
        int m = cost.length;

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][m];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        for (int j = 1; j <= k; j++) {

            for (int i = 0; i < m; i++) {

                // Option 1: Skip current window
                if (i > 0) {
                    dp[j][i] = dp[j][i - 1];
                }

                // Option 2: Take current window
                if (j == 1) {

                    dp[j][i] = Math.min(
                        dp[j][i],
                        cost[i]
                    );

                } else if (i >= x) {

                    dp[j][i] = Math.min(
                        dp[j][i],
                        cost[i] + dp[j - 1][i - x]
                    );
                }
            }
        }

        return dp[k][m - 1];
    }

    // Add element
    private void add(int num) {

        if (left.isEmpty() || num <= left.lastKey()) {

            left.put(num, left.getOrDefault(num, 0) + 1);
            sumLeft += num;
            leftSize++;

        } else {

            right.put(num, right.getOrDefault(num, 0) + 1);
            sumRight += num;
            rightSize++;
        }

        balance();
    }

    // Remove element
    private void remove(int num) {

        if (left.containsKey(num)) {
            removeLeft(num);
        } else {
            removeRight(num);
        }

        balance();
    }

    // Balance two halves
    private void balance() {

        while (leftSize > rightSize + 1) {

            int num = left.lastKey();

            removeLeft(num);
            addRight(num);
        }

        while (leftSize < rightSize) {

            int num = right.firstKey();

            removeRight(num);
            addLeft(num);
        }
    }

    private void addLeft(int num) {

        left.put(num, left.getOrDefault(num, 0) + 1);
        sumLeft += num;
        leftSize++;
    }

    private void addRight(int num) {

        right.put(num, right.getOrDefault(num, 0) + 1);
        sumRight += num;
        rightSize++;
    }

    private void removeLeft(int num) {

        left.put(num, left.get(num) - 1);

        if (left.get(num) == 0) {
            left.remove(num);
        }

        sumLeft -= num;
        leftSize--;
    }

    private void removeRight(int num) {

        right.put(num, right.get(num) - 1);

        if (right.get(num) == 0) {
            right.remove(num);
        }

        sumRight -= num;
        rightSize--;
    }

    // Calculate cost of current window
    private long getCost() {

        long median = left.lastKey();

        long leftCost = median * leftSize - sumLeft;

        long rightCost = sumRight - median * rightSize;

        return leftCost + rightCost;
    }
}
