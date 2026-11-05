class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        int n = arr1.length;
        int m = arr2.length;
        for(int i = 0 ; i < n ; i++){
            int a = arr1[i];
            boolean check = true;
            for(int j = 0 ; j < m ; j++){
                int b = arr2[j];
                int diff = Math.abs(a - b);
                if(diff <= d){
                    check = false;
                    break;
                }
            }
            if(check){
                cnt++;
            }
        }
        return cnt;
    }
}