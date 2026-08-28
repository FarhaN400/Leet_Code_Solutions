class Pair{
        int row;
        int col;
        int time;
        Pair(int i ,int j ,int t){
            this.row = i ;
            this.col = j;
            this.time = t;
        }
    }
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.offer(new Pair(i , j ,0));
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }
        int tm = 0 ; 
        int[] drow = {-1 , 0 , 1 , 0}; // up right left down
        int[] dcol = {0 , 1 , 0 , -1};
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().row; 
            int c = q.peek().col; 
            int t = q.peek().time;
            tm = Math.max(t , tm);
            q.remove();
            for(int i = 0 ; i < 4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 &&
                        vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 2;
                    q.offer(new Pair(nrow , ncol , t + 1));
                    cnt++;
                }
            } 
        }
        if(cnt != cntFresh) return -1;
        return tm;
    }
}