class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp , -1);
        return find(0 , nums, dp);
    }
    public int find(int i , int[] arr, int[] dp){
        if(i >= arr.length) {
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int take = arr[i] + find(i+2 , arr , dp);
        int skip = find(i+1 , arr , dp);
        dp[i] =  Math.max(take , skip);
        return dp[i];
    }
}