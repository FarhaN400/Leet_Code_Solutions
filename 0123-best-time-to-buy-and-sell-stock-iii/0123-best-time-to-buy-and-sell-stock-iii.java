class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n+1][2][3];
        // for(int i = 0 ; i<2 ; i++){
        //     for(int j = 0 ; j <3 ; j++){
        //         dp[n][i][j] = 0;
        //     }
        // }
        for(int i = n-1 ; i>=0 ; i--){
            for(int buy = 0 ; buy <= 1 ; buy++){
                for(int cap = 2 ; cap > 0 ; cap--){
                    if(buy == 0){
                        dp[i][buy][cap] = Math.max(
                            -arr[i] + dp[i+1][1][cap],
                            dp[i+1][0][cap]
                        );
                    }else{
                        dp[i][buy][cap] = Math.max(
                            arr[i] + dp[i+1][0][cap-1],
                            dp[i+1][1][cap]
                        );
                    }
                }
            }
        }
        return dp[0][0][2];
    }
    public int helper(int i , int buy , int cap , int[] arr , int[][][] dp){
        if(cap == 0) return 0;
        if(i == arr.length) return 0;
        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];
        if(buy == 0){
            return dp[i][buy][cap] = Math.max(
                -arr[i] + helper(i+1 , 1 , cap , arr , dp),
                helper(i+1 , 0 , cap , arr , dp)
            );
        }else{
            return dp[i][buy][cap] = Math.max(
                arr[i] + helper(i+1 , 0 , cap-1 , arr , dp),
                helper(i+1 , 1 , cap , arr , dp)
            );
        }
    }
}