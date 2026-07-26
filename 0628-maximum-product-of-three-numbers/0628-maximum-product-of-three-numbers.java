class Solution {
    public int maximumProduct(int[] arr) {
        // int n = nums.length;
        // Arrays.sort(nums);
        // int temp1 =  nums[n-1] * nums[n-2] * nums[n-3];
        // int temp2 = nums[0] * nums[1] * nums[n-1];
        // return Math.max(temp1 , temp2);
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;
        int tlargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int ssmallest = Integer.MAX_VALUE;
        for(int i=0 ; i<arr.length ;i++){
            if(arr[i] > largest){
                tlargest = slargest;
                slargest = largest;
                largest = arr[i];
            }
            else if(arr[i] > slargest){
                tlargest = slargest;
                slargest = arr[i];
            }
            else if(arr[i] > tlargest){
                tlargest = arr[i];
            }
            if(arr[i] < smallest){
                ssmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] < ssmallest){
                ssmallest = arr[i];
            }
        }
        return Math.max(
            largest * slargest * tlargest,
            smallest * ssmallest * largest
        );
    }
}