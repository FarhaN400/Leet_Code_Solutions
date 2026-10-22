class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                idx = i;
                break;
            }
        }
        boolean forward = true;
        for(int i = 0 ; i < n ; i++){
            if(nums[(idx+i) % n] != i){
                forward = false;
                break;
            }
        }
        boolean backward = true;
        if(!forward){
            for(int i = 0 ; i < n ; i++){
                if(nums[(idx - i + n) % n] != i){
                    backward = false;
                    break;
                }
            }
        }
        if(!forward && !backward) return -1;
        if(forward) {
            return Math.min(idx ,n - idx + 2);
        }
        return Math.min(n - idx , idx + 2);
    }
}