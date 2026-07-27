class Solution {
    public int maxProduct(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i =0 ; i<arr.length ; i++){
            if(arr[i] >= first){
                second = first;
                first = arr[i];
            }
            if(arr[i] > second && arr[i] < first){
                second = arr[i];
            }
        }
        return (first - 1)*(second - 1);
    }
}