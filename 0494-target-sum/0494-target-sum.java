class Solution {
    public int findTargetSumWays(int[] arr, int target) { 
        int totalSum = 0;
        for(int i = 0 ; i< arr.length ; i++){
            totalSum += arr[i];
        }
        int k = (totalSum - target)/2 ;
        if ((totalSum - target) < 0 || (totalSum - target) % 2 != 0) return 0;
        int[][] dp = new int[arr.length][k+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(arr.length - 1 , k , arr , dp);
    }
    public int helper(int i , int t , int[] arr , int[][] dp){
        if(i == 0){
            if(t==0 && arr[i] == t){
                return 2;
            }if(t == 0 || arr[0] == t){
                return 1;
            }
            return 0;
        }
        if(dp[i][t] != -1) return dp[i][t];
        int nPick = helper(i-1 , t , arr ,dp);
        int Pick = 0;
        if(t >= arr[i]){
            Pick = helper(i-1 , t - arr[i] , arr , dp);
        }
        dp[i][t] =  Pick + nPick;
        return dp[i][t];
    }
}