class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while(l < m && r < n){
            if(s[l] >= g[r]){
                l++;
                r++;
            }else{
                l++;
            }
        }
        return r;
    }
}