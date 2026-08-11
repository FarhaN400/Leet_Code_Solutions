class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        // for(int[] row : dp){
        //     Arrays.fill(row , -1);
        // }
        // return helper(0 , 0 , prices , dp);
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;
        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int buy = 0 ; buy <= 1 ; buy++){
                if(buy==0){
                    dp[i][buy] = Math.max(
                        -prices[i] + dp[i+1][1],
                        dp[i+1][0]
                    );
                }
                else{
                    dp[i][buy] = Math.max(
                        prices[i] + dp[i+1][0],
                        dp[i+1][1]
                    );
                }
            }
        }
        return dp[0][0];
    }
    public int helper(int i , int buy , int[] arr , int[][] dp){
        int profit = 0;
        if(i == arr.length){
            return 0;
        }
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 0){
            profit = Math.max(
                -arr[i] + helper(i+1 , 1 , arr , dp),
                helper(i+1 , 0 , arr , dp)
            );
        }else{
            profit = Math.max(
                arr[i] + helper(i+1 , 0 , arr , dp),
                helper(i+1 , 1 , arr , dp)
            );
        }
        return dp[i][buy] = profit;
    }
}