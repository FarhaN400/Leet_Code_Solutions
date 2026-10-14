class Solution {
    public int divide(int x, int y) {
        if(x == y) return 1;
        boolean sign = true;
        if(x>=0 && y < 0) sign = false;
        if(y>=0 && x < 0) sign = false;
        long n = Math.abs((long)x);
        long d = Math.abs((long)y);
        long ans = 0;
        while(n >= d){
            int cnt = 0;
            while(n >= (d << (cnt+1))){
                cnt += 1;
            }
            ans += 1L << cnt;
            n -= (d << cnt);
        }
        if(ans > Integer.MAX_VALUE && sign){
            return Integer.MAX_VALUE;
        }
        if(ans > Integer.MAX_VALUE && !sign){
            return Integer.MIN_VALUE;
        }
        return sign ? (int)ans : (int)-ans;
    }
}