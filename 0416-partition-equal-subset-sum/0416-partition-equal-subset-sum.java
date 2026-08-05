class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0 ; i<nums.length ;i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for(int[] row : dp) {
            Arrays.fill(row , -1);
        }
        return helper(nums.length - 1 , target , nums , dp);
    }
    public boolean helper(int i , int target , int[] arr , int[][] dp){
        if(target == 0) return true;
        if(i == 0){
            return (arr[0] == target);  
        }
        if(dp[i][target] != -1) return dp[i][target] == 1;
        boolean notTake = helper(i-1 , target , arr , dp);
        boolean Take = false;
        if(target >= arr[i]){
            Take = helper(i-1 , target - arr[i] , arr , dp);
        }
        dp[i][target] = (notTake || Take) ? 1 : 0;
        return dp[i][target] == 1;
    }
}