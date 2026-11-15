class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        int cnt = 0 ;
        int n = arr.length;
        int odd = 0;
        int even = 1;
        int sum = 0;
        for(int num : arr){
            sum += num;
            if(sum % 2 == 0){
                cnt = (cnt + odd) % mod;
                even++;
            }else{
                cnt = (cnt + even) % mod;
                odd++;
            }
        }
        return cnt;
    }
}