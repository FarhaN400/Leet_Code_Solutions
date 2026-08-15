class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return helper(0 , 0 , prices , dp);
    }
    public int helper(int i , int buy , int[] arr ,int[][] dp){
        if(i >= arr.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(
                -arr[i] + helper(i+1 , 1 , arr , dp),
                helper(i+1 , 0 , arr , dp)
            );
        }else{
            profit = Math.max(
                arr[i] + helper(i+2 , 0 , arr , dp),
                helper(i+1 , 1 , arr , dp)
            );
        }
        return dp[i][buy] = profit;
    }
}