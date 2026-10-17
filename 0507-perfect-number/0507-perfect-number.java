class Solution {
    public boolean checkPerfectNumber(int num) {
        // int temp = 0;
        // for(int i = 1 ; i < num ; i++){
        //     if(num % i == 0){
        //         temp += i;
        //     }
        // }
        // return temp == num;
        if(num <= 1) return false;
        int temp = 1;
        for(int i = 2 ; i < num / i ; i++){
            if(num % i == 0){
                temp = temp + i;
                if(i != num/i){
                    temp += num/i;
                }
            }
        }
        return temp == num;
    }
}