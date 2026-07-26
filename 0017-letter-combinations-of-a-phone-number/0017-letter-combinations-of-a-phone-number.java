class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        generate(0,digits,map,ans,"");
        return ans;
    }
    public void generate(int idx , String digit , String[] map ,List<String> ans , String CurrStr){
        if(CurrStr.length() == digit.length()) {
            ans.add(CurrStr);
            return;
        }
        String letter = map[digit.charAt(idx)-'0'];
        for(int i=0;i<letter.length();i++){
            char c = letter.charAt(i);
            generate(idx+1 , digit , map , ans , CurrStr + c);
        }
    }
}