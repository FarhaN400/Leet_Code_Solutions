class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        for(int j = 0 ; j <= m ; j++) dp[0][j] = 0;
        for(int i = 0 ; i <= n ; i++) dp[i][0] = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j<= m ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(
                        dp[i-1][j] ,
                        dp[i][j-1]
                    );
                }
            }
        }
        return dp[n][m];
    }
    public int helper(int i , int j, String str1, String str2, int[][] dp){
        if(i <0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == (str2.charAt(j))){
            dp[i][j] = 1 + helper(i - 1 , j- 1 , str1 , str2 , dp);
            return dp[i][j];
        }
        dp[i][j] =  Math.max(helper(i-1 , j , str1 , str2 , dp) , helper(i , j- 1 , str1 ,str2 , dp));
        return dp[i][j];
    }
}