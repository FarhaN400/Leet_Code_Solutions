class Solution {
    public int missingNumber(int[] arr) {
        int i=0;
        while (i < arr.length ) {
            if(arr[i] >= arr.length){
                i++;
            }
            else if ((arr[i]) != i) {
                Swap(arr, i, (arr[i]));
            } 
            else{
                i++;
            }
        }
        return missing(arr);
    }
    public void Swap(int[] arr ,int a , int b){
        int temp = arr[a];
        arr[a]= arr[b] ;
        arr[b] = temp ;

    }
    public int missing(int [] arr){
        int N = arr.length ;
        for(int i=0;i<arr.length;i++){
            if (arr[i] != i) {
                return i;
            }
        }
        return N;
    }
}
