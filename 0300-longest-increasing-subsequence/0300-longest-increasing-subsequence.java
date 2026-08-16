class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+2];
        // for(int[] row : dp){
        //     Arrays.fill(row , -1);
        // }
        // return helper(0 , -1 , nums , dp);
        int len = 0;
        for(int i = n -1 ; i>=0 ; i--){
            for(int p = -1 ; p <= n-1 ; p++){
                len = dp[i+1][p+1];
                if(p == -1 || nums[i] > nums[p]){
                    len = Math.max(len,1 + dp[i+1][i+1]);
                }
                dp[i][p+1] = len;
            }
        }

        return dp[0][0];
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