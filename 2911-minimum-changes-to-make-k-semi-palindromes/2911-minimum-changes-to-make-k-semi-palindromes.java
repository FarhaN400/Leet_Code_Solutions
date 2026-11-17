
import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        int[][] dp2 = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int[] row : dp2) {
            Arrays.fill(row, -1);
        }
        return Solve(0, k, s, dp, dp2);
    }
    public int Solve(int start, int k, String s,
                     int[][] dp, int[][] dp2) {
        if (k == 0) {
            return (start == s.length()) ? 0 : Integer.MAX_VALUE;
        }
        if (s.length() - start < 2 * k) {
            return Integer.MAX_VALUE;
        }
        if (dp[start][k] != -1) {
            return dp[start][k];
        }
        int min_cost = Integer.MAX_VALUE;
        for (int end = start + 1; end < s.length(); end++) {
            int futureCost = Solve(end + 1, k - 1, s, dp, dp2);
            int currCost = helper(start, end, s, dp2);
            if (futureCost != Integer.MAX_VALUE) {
                min_cost = Math.min(min_cost,
                                    futureCost + currCost);
            }
        }
        return dp[start][k] = min_cost;
    }
    public int helper(int start, int end, String s, int[][] dp2) {
        if (dp2[start][end] != -1) {
            return dp2[start][end];
        }
        int min_cost = Integer.MAX_VALUE;
        int len = end - start + 1;
        for (int d = 1; d < len; d++) {
            if (len % d != 0) {
                continue;
            }
            int cost = 0;
            for (int g = 0; g < d; g++) {
                int left = start + g;
                int right = left + (len - d);
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        cost++;
                    }
                    left += d;
                    right -= d;
                }
            }
            min_cost = Math.min(min_cost, cost);
        }
        return dp2[start][end] = min_cost;
    }
}