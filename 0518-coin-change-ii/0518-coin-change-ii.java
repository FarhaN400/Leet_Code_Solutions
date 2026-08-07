class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row: dp){
            Arrays.fill(row , -1);
        }
        return helper(coins.length -1 , amount , coins , dp);
    }
    public int helper(int i , int t , int[] arr ,int[][] dp){
        if(i < 0 || t < 0) return 0;
        if(t == 0){
            return 1;
        }
        if(dp[i][t] != -1) return dp[i][t];
        int pick = helper(i , t - arr[i] , arr , dp);
        int npick = helper(i - 1 , t  , arr , dp);
        dp[i][t] = pick + npick;
        return dp[i][t];
    }
}