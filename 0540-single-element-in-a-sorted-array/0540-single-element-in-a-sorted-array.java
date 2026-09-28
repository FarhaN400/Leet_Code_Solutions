class Solution {
    public int singleNonDuplicate(int[] nums) {
        // if(nums.length == 1) return nums[0];
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(i == 0){
        //         if(nums[i] != nums[i+1]) return nums[i];
        //     }else if(i == nums.length - 1){
        //         if(nums[i] != nums[i-1]) return nums[i];
        //     }
        //     else{
        //         if(nums[i-1] != nums[i] && nums[i+1] != nums[i]){
        //             return nums[i];
        //         }
        //     }
        // }
        // return 1;
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        int s = 1 ; 
        int e = n - 2 ;
        while(s <= e){
            int m = (s + e) / 2;
            if(nums[m - 1] != nums[m] && nums[m+1] != nums[m]){
                return nums[m];
            }
            if((m % 2 == 0 && nums[m-1] == nums[m]) || (m % 2 == 1 && nums[m+1] == nums[m])){
                e = m - 1;
            }
            else{
                s = m + 1;
            }
        }
        return 1;
    }
}