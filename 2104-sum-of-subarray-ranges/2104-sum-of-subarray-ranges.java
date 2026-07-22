class Solution {
    public long subArrayRanges(int[] arr) {
        long sum = 0;
        for(int i=0 ; i < arr.length ; i++){
            int largest = arr[i];
            int smallest = arr[i];
            for(int j = i ; j < arr.length ; j++){
                largest = Math.max(largest , arr[j]);
                smallest = Math.min(smallest , arr[j]);
                sum += (largest - smallest);
            }
        }
        return sum;
    }
}