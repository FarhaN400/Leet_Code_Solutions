class Solution {
    public int smallestNumber(int n, int t) {
        int temp = 0;
        while(true){
            int pdt = Product(n);
            if(pdt % t == 0){
                temp = n;
                break;
            }
            n++;
        }
        return temp;
    }
    public int Product(int n){
        int temp = 1;
        while(n != 0){
            temp *= n % 10;
            n = n/10;
        }
        return temp;
    }
}