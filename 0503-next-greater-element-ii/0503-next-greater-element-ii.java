class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] nge = new int[arr.length];
        for(int i=0 ; i<arr.length ; i++){
            nge[i] = find(arr , i);
        }
        return nge;
    }
    public int find(int[] arr,int i){
        for(int count=1 ; count < arr.length ; count++){
            int idx = (i+count) % arr.length;
            if(arr[idx] > arr[i]){
                return arr[idx];
            }
        }
        return -1;
    }
}