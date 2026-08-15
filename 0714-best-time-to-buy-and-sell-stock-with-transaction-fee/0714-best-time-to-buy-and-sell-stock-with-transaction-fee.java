class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return helper(0 , 0 , fee , prices , dp);
    }
    public int helper(int i , int buy ,int fee, int[] arr , int[][] dp){
        int profit = 0;
        if(i == arr.length){
            return 0;
        }
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 0){
            profit = Math.max(
                -arr[i] + helper(i+1 , 1 ,fee , arr , dp),
                helper(i+1 , 0 , fee , arr , dp)
            );
        }else{
            profit = Math.max(
                arr[i] - fee + helper(i+1 , 0 ,fee, arr , dp),
                helper(i+1 , 1 ,fee , arr , dp)
            );
        }
        return dp[i][buy] = profit;
    }
}