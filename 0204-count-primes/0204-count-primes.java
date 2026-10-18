class Solution {
    public int countPrimes(int n) {
        // if(n <= 2) return 0;
        // int cnt = 1;
        // for(int i = 3 ; i < n ; i++){
        //     if(prime(i)){
        //         cnt++;
        //     }
        // }
        // return cnt;
        if(n <= 2) return 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime , true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 0 ; i * i <= n ; i++){
            if(isPrime[i]){
                for(int j = i * i ; j <= n ; j += i){
                    isPrime[j] = false;
                }
            }
        }
        int cnt = 1;
        for(int i = 3 ; i < n ; i++){
            if(isPrime[i]) cnt++;
        }
        return cnt;
    }
    public boolean prime(int n){
        for(int i = 2 ; i <= n / i ; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}