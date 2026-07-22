class Solution {
    public int[] asteroidCollision(int[] arr) {
        ArrayList<Integer> st = new ArrayList<>();
        for(int i=0 ; i < arr.length ; i++){
            if(arr[i] > 0) st.add(arr[i]);
            else{
                while(!st.isEmpty() && st.get(st.size() - 1) < Math.abs(arr[i]) && st.get(st.size() - 1) > 0 ){
                    st.remove(st.size() - 1);
                }
                if(!st.isEmpty() && st.get(st.size() - 1) == Math.abs(arr[i])){
                    st.remove(st.size() - 1);
                }else if(st.isEmpty() || st.get(st.size() - 1) < 0){
                    st.add(arr[i]);
                }
            }
        }
        int[] ans = new int[st.size()];
        for(int i=0 ; i<st.size() ;i++){
            ans[i] = st.get(i);
        }
        return ans;
    }
}