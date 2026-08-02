class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2,-1);

        int case1 =  find(0 , nums.length - 2 , nums, dp1);
        int case2 =  find(1 , nums.length - 1 , nums , dp2);
        return Math.max(case1 , case2);
    }
    public int find(int i , int end , int[] arr, int[] dp){
        if(i > end) {
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int take = arr[i] + find(i+2, end , arr , dp);
        int skip = find(i+1 , end ,arr , dp);
        dp[i] =  Math.max(take , skip);
        return dp[i];
    }
}