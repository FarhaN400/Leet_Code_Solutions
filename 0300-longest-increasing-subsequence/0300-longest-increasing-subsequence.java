class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return helper(0 , -1 , nums , dp);
    }
    public int helper(int i , int p , int[] arr , int[][] dp){
        if(i == arr.length) return 0;
        if(dp[i][p+1] != -1) return dp[i][p+1];
        int len = 0;
        len = helper(i+1 , p , arr , dp);
        if(p == -1 || arr[i] > arr[p]){
            len = Math.max(len,1 + helper(i+1 , i , arr , dp));
        }
        return dp[i][p+1] = len;
    }
}