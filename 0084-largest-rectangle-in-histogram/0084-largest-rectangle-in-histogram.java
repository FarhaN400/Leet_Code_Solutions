class Solution {
    public int largestRectangleArea(int[] arr) {
        int[] nse = findnse(arr);
        int[] pse = findpse(arr);
        int maxi = 0 ;
        for(int i =0 ; i < arr.length ; i++){
            maxi = Math.max(maxi , arr[i]*(nse[i]-pse[i]-1));
        }
        return maxi;
    }
    public int[] findnse(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack();
        int[] ans = new int[n];
        Arrays.fill(ans,n);
        for(int i = n - 1 ; i >= 0; i--){
            while(!st.isEmpty() && arr[(st.peek())]  >= arr[i]) st.pop();
            if(!st.isEmpty()) ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] findpse(int[] arr){
        Stack<Integer> st = new Stack();
        int[] ans = new int[arr.length];
        Arrays.fill(ans , -1);
        for(int i=0 ; i<arr.length ; i++){
            while(!st.isEmpty() && arr[(st.peek())] >= arr[i]) st.pop();
            if(!st.isEmpty()) ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
}