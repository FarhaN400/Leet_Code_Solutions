class Solution {
    public int trap(int[] arr) {
        int total = 0;
        int[] left = preffixMax(arr);
        int[] right = suffixMax(arr);
        for(int i=0;i<arr.length;i++){
            int leftmax = left[i];
            int rightmax = right[i];
            if(arr[i] < leftmax && arr[i] < rightmax) {
                total += (Math.min(leftmax , rightmax) - arr[i]);
            }
        }
        return total;
    }
    public int[] preffixMax(int[] arr){
        int[] preffix = new int[arr.length];
        preffix[0] = arr[0];
        for(int i=1 ; i<arr.length ;i++){
            preffix[i] = Math.max(preffix[i-1] , arr[i]);
        }
        return preffix;
    }
    public int[] suffixMax(int[] arr){
        int[] suffix = new int[arr.length];
        suffix[arr.length - 1] = arr[arr.length - 1];
        for(int i= arr.length - 2; i >= 0 ;i--){
            suffix[i] = Math.max(suffix[i+1] , arr[i]);
        }
        return suffix;
    }
}