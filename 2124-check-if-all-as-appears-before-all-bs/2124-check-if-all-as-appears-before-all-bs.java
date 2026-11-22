class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int b =0;
        for(int i = 0 ; i < n ; i++){
            if(b == 1){
                if(s.charAt(i) == 'a'){
                    return false;
                }
            }
            else if(s.charAt(i) == 'b'){
                b =1;
            }
        }
        return true;
    }
}