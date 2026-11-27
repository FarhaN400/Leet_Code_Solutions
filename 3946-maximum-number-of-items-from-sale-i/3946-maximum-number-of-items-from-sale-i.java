class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] gain = new int[n];
        int minPrice = Integer.MAX_VALUE;
        int[][] dp = new int[n][budget + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);

            for (int j = 0; j < n; j++) {
                if (items[j][0] % items[i][0] == 0) {
                    gain[i]++;
                }
            }
        }

        return solve(0, budget, items, gain, minPrice,dp);
    }

    public int solve(int idx, int budget, int[][] items,
                 int[] gain, int minPrice, int[][] dp) {

        if (idx == items.length) {
            return budget / minPrice;
        }

        if (dp[idx][budget] != -1) {
            return dp[idx][budget];
        }

        int notPick = solve(idx + 1, budget,
                            items, gain, minPrice, dp);

        int pick = 0;

        if (items[idx][1] <= budget) {
            pick = gain[idx] +
                solve(idx + 1, budget - items[idx][1],
                        items, gain, minPrice, dp);
        }

        return dp[idx][budget] = Math.max(pick, notPick);
    }
}