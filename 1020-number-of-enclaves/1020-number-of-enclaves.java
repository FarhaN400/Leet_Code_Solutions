class Pair{
    int first ;
    int second;
    Pair(int a , int b){
        this.first = a;
        this.second = b;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int j = 0 ; j < n ; j++){
            if(grid[0][j] == 1){
                vis[0][j] = 1;
                q.offer(new Pair(0,j));
            }
        }
        for(int j = 0 ; j < n ; j++){
            if(grid[m-1][j] == 1){
                vis[m-1][j] = 1;
                q.offer(new Pair(m-1,j));
            }
        }
        for(int i = 0 ; i < m ; i++){
            if(grid[i][0] == 1){
                vis[i][0] = 1;
                q.offer(new Pair(i,0));
            }
        }
        for(int i = 0 ; i < m ; i++){
            if(grid[i][n-1] == 1){
                vis[i][n-1] = 1;
                q.offer(new Pair(i,n-1));
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            for(int i = 0 ; i< 4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < m && ncol >=0 && ncol < n && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    q.offer(new Pair(nrow , ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i = 0 ; i<m ; i++){
            for(int j =0 ; j < n ; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}