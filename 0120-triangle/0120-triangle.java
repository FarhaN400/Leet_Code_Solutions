class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle);
    }
    public int helper(List<List<Integer>> triangle){
        int [][] dp = new int[triangle.size()][triangle.size()];
        for(int[] row : dp) {
            Arrays.fill(row , -1);
        }
        for (int j = 0; j < triangle.size(); j++) {
            dp[triangle.size() - 1][j] = triangle.get(triangle.size() - 1).get(j);
        }
        for(int i = triangle.size() - 2 ; i>=0 ; i--){
            for(int j = i ; j>= 0 ; j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int dia = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down , dia);
            }
        }
        return dp[0][0];
    }
}