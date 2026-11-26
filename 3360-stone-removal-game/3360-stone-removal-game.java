class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        if(n-10 < 9) return true;
        n = n - 10;
        boolean alice = false;
        boolean bob = false;
        for(int i = 9 ; i >= 0 ; i--){
            if(i % 2 != 0){
                bob = true;
                alice = false;
            }else{
                alice = true;
                bob = false;
            }
            if(n-i >= i-1){
                n = n - i;
            }else{
                return (alice) ? true : false;
            }
        }
        return true;
    }
}