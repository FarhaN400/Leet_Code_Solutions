class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        int cnt = 0;
        while((n & 1) == 0){
            n = n >> 1;
            cnt++;
        }
        return ((n==1) && (cnt % 2 ==0));
    }
}