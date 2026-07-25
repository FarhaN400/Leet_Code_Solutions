class Solution {
    public List<List<Integer>> combinationSum3(int k, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        find(1,t,k,ans,new ArrayList<>());
        return ans;
    }
    public void find(int idx , int t , int k ,List<List<Integer>> ans, List<Integer> ds){
        if(t == 0 && k == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(k==0 || t<0)  return;
        for(int i=idx ; i<10 ; i++){
            ds.add(i);
            find(i+1 ,t-i , k-1 ,ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}