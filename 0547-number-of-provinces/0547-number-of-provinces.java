class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < isConnected.length ; i++){
            adj.add(new ArrayList<>());
            for(int j = 0 ; j < isConnected.length ; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                }
            }
        }
        int cnt = 0;
        int[] vis = new int[isConnected.length];
        for(int i = 0 ; i < isConnected.length ; i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i , adj , vis);
            }
        }
        return cnt;
    }
    public void dfs(int i , ArrayList<ArrayList<Integer>> adj , int[] vis){
        vis[i] = 1;
        for(int neighbour : adj.get(i)){
            if(vis[neighbour] == 0){
                dfs(neighbour , adj , vis);
            }
        }
    }
}