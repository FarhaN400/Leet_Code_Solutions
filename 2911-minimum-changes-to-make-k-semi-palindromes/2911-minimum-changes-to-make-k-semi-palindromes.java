class Solution {
    public int minimumChanges(String s, int k) {
        int[][] dp = new int[s.length() + 1][k+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return Solve(0 , k , s , dp);
    }
    public int Solve(int start, int k , String s , int[][] dp){
        if(k == 0){
            return (start == s.length()) ? 0 : Integer.MAX_VALUE;
        }
        if (s.length() - start < 2 * k) {
            return Integer.MAX_VALUE;
        }
        if(dp[start][k] != -1) return dp[start][k];
        int min_cost = Integer.MAX_VALUE;
        for(int end = start + 1 ; end < s.length() ; end++){
            int futureCost = Solve(end+1 , k-1 , s , dp);
            int currCost = helper(start , end , s);
            if(futureCost != Integer.MAX_VALUE){
                min_cost = Math.min(min_cost , futureCost + currCost);
            }
        }
        return dp[start][k] = min_cost;
    }
    public int helper(int start , int end , String s){
        int min_cost = Integer.MAX_VALUE;
        int len = end - start + 1;
        for(int d = 1 ; d < len ; d++){
            if(len % d != 0){
                continue;
            }
            int cost = 0 ;
            for(int g = 0 ; g < d ; g++){
                int left = start + g;
                int right = left + (len - d);
                while(left < right){
                    if(s.charAt(left) != s.charAt(right)){
                        cost++;
                    }
                    left += d;
                    right -= d;
                }
            }
            min_cost = Math.min(min_cost , cost);
        }
        return min_cost;
    }
}