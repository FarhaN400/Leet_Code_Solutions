class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return helper(n-1 , m-1 , s , p , dp);
    }
    public boolean helper(int i , int j , String s , String p , int[][] dp){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            for(int k = 0 ; k <= j ; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1 ;
        boolean ans = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            ans = helper(i-1 , j-1 , s , p , dp);
        }
        else if(p.charAt(j) == '*'){
            ans = helper(i-1 , j , s ,p , dp)  || helper(i , j-1 , s ,p ,dp);
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}