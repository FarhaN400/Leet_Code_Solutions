class Solution {
    public String longestPalindrome(String s) {
        int l = 0;
        int r = 0;
        String ans = "";
        for(int i = 0; i < s.length() ; i++){
            String even = helper(s , i , i+1);
            String odd = helper(s , i , i);
            String temp = even.length() > odd.length() ? even : odd;
            if(temp.length() > ans.length()){
                ans = temp;
            }
        }
        return ans;
    }
    public String helper(String s , int l , int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;r++;
        }
        return s.substring(l+1 , r);
    }
}