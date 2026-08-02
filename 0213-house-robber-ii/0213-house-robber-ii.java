class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] arr1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1, nums.length);

        int[] dp1 = new int[arr1.length];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[arr2.length];
        Arrays.fill(dp2,-1);
        
        int case1 =  find(0 , arr1, dp1);
        int case2 =  find(0 , arr2, dp2);
        return Math.max(case1 , case2);
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