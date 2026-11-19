class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        return helper(2 , 0 , nums.length - 1 , nums);
    }
    public int helper(int k , int l , int r , int[] nums){
        if(k == 0) return nums[r] - nums[l];
        int a = helper(k-1 , l+1 , r , nums);
        int b = helper(k-1 , l , r - 1 , nums);
        return Math.min(a,b);
    }
}