class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        generate(0,nums,ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }
    public void generate(int idx , int[] arr, Set<List<Integer>> ans ,List<Integer> ds){
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