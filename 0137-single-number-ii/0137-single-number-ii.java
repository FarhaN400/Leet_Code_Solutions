class Solution {
    public int singleNumber(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        // HashMap<Integer , Integer> map = new HashMap<>();
        // for(int i =0 ; i < n ; i++){
        //     map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        // }
        // for(int i = 0 ; i < arr.length ; i++){
        //     if(map.get(arr[i]) == 1) return arr[i];
        // }
        // return -1;
        Arrays.sort(arr);
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        for(int i = 1 ; i < n ; i++){
            if(arr[i] != arr[i-1] && arr[i] != arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }
}