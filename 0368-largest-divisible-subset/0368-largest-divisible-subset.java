class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int maxi = 1;
        int lastidx = 0;
        Arrays.sort(nums);
        
        List<Integer> ans = new ArrayList<>();

        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        int[] hash = new int[n];

        for(int i = 0 ; i<n ; i++){
            hash[i] = i;
            for(int p = 0 ; p < i ; p++){
                if(nums[i] % nums[p] == 0 && 1+dp[p] > dp[i]){
                    dp[i] = 1 + dp[p];
                    hash[i] = p;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastidx = i;
            }
        }
        int i = lastidx;
        while(hash[i] != i){
            ans.add(nums[i]);
            i = hash[i];
        }
        ans.add(nums[i]);
        return ans;
    }
}