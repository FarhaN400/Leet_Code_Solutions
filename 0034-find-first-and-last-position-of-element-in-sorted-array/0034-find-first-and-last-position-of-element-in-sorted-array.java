class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,1};
        // Check for first Occurence
        ans[0] = Search(nums , target , true);
        ans[1] = Search(nums , target , false);
        return ans; 
    }
    int Search(int[] nums,int target,boolean FirstIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start<=end ){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                ans = mid ;
                if(FirstIndex){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}