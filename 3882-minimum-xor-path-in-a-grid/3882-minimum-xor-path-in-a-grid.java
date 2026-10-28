class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][1024];
        for(int[][] t : dp){
            for(int[] r : t){
                Arrays.fill(r , -1);
            }
        }
        return helper(m - 1, n - 1, 0,grid , dp);
    }
    public int helper(int i , int j ,int xor, int[][] grid , int[][][] dp){
        if(i == 0 && j == 0) return xor ^ grid[i][j];
        else if(i < 0 || j < 0) return Integer.MAX_VALUE;
        int nxor = xor ^ grid[i][j];
        if(dp[i][j][nxor] != -1) return dp[i][j][nxor];
        int up = helper(i - 1 , j , nxor , grid , dp);
        int left = helper(i , j - 1  , nxor , grid , dp);
        dp[i][j][nxor] = Math.min(up ,left);
        return dp[i][j][nxor];
    }
}