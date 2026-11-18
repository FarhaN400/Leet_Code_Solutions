class Solution {
    public int minChanges(String s) {
        int changes = 0;
        int len = 1;
        int exp = s.charAt(0) - '0';
        for(int i = 1; i < s.length() ; i++){
            if(exp == s.charAt(i) - '0') len++;
            else if(len % 2 == 0){
                exp = 1 - exp;
                len = 1;
            }else{
                changes++;
                exp = 1 - exp;
                len = 0;
            }
        }
        return changes;
    }
}