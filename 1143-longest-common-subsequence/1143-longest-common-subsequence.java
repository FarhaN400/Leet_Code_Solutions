class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return helper(str1.length() - 1 , str2.length() - 1 , str1 ,str2 , dp);
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