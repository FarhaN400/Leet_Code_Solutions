class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,nums,ans, new ArrayList<>());
        return ans;
    }
    public void generate(int idx , int[] arr, List<List<Integer>> ans ,List<Integer> ds){
        if(idx == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[idx]);
        generate(idx + 1 , arr , ans , ds);
        ds.remove(ds.size() - 1);
        generate(idx+1 , arr , ans , ds);
    }
}