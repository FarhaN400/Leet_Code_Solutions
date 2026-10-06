class Solution {
    public int singleNumber(int[] arr) {
        int n = arr.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i =0 ; i < n ; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(map.get(arr[i]) == 1) return arr[i];
        }
        return -1;
    }
}