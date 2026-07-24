class Solution {
    public int countGoodNumbers(long n) {
        int mod = (int)(1e9+7);
        long e = n/2;
        long o = n - n/2;
        long first = myPow(4,e);
        long second = myPow(5,o);
        return (int)((first * second) % mod);
    }
    public long myPow(long x,long n){
        long power=n;
        if(power<0){
            x=1/x;
            power=-power;
        }
        return solve(x,power);
    }
    public long solve(long x,long n){
        int mod = (int)(1e9+7);
        if(n==0)
            return 1;
        long half=solve(x,n/2);
        if(n%2==0)
            return (half*half)%mod;
        return (((x*half)%mod)*half)%mod;
    }
}