class Solution {
    public boolean isPalindrome(int x) {
        int y = x;
        if(x < 0) return false;
        int temp = 0;
        while(x != 0){
            int digit = x % 10; 
            x = x / 10; 
            temp = 10 * temp + digit; 
        }
        if(temp == y){
            return true;
        } 
        return false;
    }
}