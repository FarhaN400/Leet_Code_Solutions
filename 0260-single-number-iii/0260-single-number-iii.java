class Solution {
    public int[] singleNumber(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        if(arr[0] != arr[1]) ans.add(arr[0]);
        if(arr[n-1] != arr[n-2]) ans.add(arr[n-1]);
        for(int i = 1 ; i < n-1 ; i++){
            if(arr[i] != arr[i+1] && arr[i] != arr[i-1]){
                ans.add(arr[i]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}