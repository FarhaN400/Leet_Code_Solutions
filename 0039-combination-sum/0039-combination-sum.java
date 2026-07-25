class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        find(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void find(int idx , int[] arr , int t ,List<List<Integer>> ans ,List<Integer> ds){
        if(idx == arr.length){
            if(t == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[idx] <= t){
            ds.add(arr[idx]);
            find(idx,arr,t - arr[idx] , ans , ds);
            ds.remove(ds.size()-1);
        }
        find(idx + 1 , arr , t , ans , ds);
    }
}