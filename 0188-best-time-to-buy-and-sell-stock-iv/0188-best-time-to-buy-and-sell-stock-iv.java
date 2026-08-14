class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] arr : dp){
            for(int[] row : arr){
                Arrays.fill(row,-1);
            }
        }
        return helper(0 , 0 , k , prices , dp);
    }
    public int helper(int i , int buy , int cap , int[] arr , int[][][] dp){
        if(cap == 0) return 0;
        if(i == arr.length) return 0;
        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];
        if(buy == 0){
            return dp[i][buy][cap] = Math.max(
                -arr[i] + helper(i+1 , 1 , cap , arr , dp),
                helper(i+1 , 0 , cap , arr , dp)
            );
        }else{
            return dp[i][buy][cap] = Math.max(
                arr[i] + helper(i+1 , 0 , cap-1 , arr , dp),
                helper(i+1 , 1 , cap , arr , dp)
            );
        }
    }
}