class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length];
        for(int i = 0 ; i< arr1.length ; i++){
            temp[i] = find(arr2 , arr1[i]);
        }
        return temp;
    }
    public int find(int[] arr , int k){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == k){
                for(int j = i + 1 ; j< arr.length ; j++){
                    if(arr[j] > k){
                        return arr[j];
                    }
                }
                return -1;
            }
        }
        return -1;
    }
}