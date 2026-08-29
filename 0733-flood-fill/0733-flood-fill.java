class Pair{
    int first;
    int second;
    Pair(int i , int j){
        this.first = i;
        this.second = j;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = image;
        int original = image[sr][sc];

        if(original == color) {
            return image;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr , sc));

        int[] drow = {-1 , 0 , 1 , 0};
        int[] dcol = {0 , 1 , 0 , -1};

        ans[sr][sc] = color;

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            for(int i = 0 ; i < 4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == original){
                    ans[nrow][ncol] = color;
                    q.offer(new Pair(nrow , ncol));
                }
            }
        }
        return ans;
    }
}