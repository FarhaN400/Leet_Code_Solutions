class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        int ans = recurs(coins , amount ,dp);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }
    public int recurs(int[] coins , int amount , int[] dp){
        if(amount == 0) return 0; 
        if(amount < 0 ) return Integer.MAX_VALUE;
        if(dp[amount] != -1) return dp[amount];
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i< coins.length ;i++){
            int ans = recurs(coins , amount - coins[i] , dp);
            if(ans != Integer.MAX_VALUE){
                min = Math.min(min , 1+ans);
            }
        }
        dp[amount] = min;
        return min;
    }
}