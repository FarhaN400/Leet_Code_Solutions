class Solution {
    public int minSubArrayLen(int t, int[] nums) {
        int len = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0 ; right < nums.length ;right++){
            sum += nums[right]; 
            while(sum >= t){
                len = Math.min(len , right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}