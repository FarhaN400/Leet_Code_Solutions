class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for(int i = 0 ; i < n ; i += 2*k){
            helper(arr , i ,Math.min(i + k - 1 , n-1));
        }
        return new String(arr);
    }
    public void helper(char[] s , int i , int j){
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
    }
}