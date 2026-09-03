class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        // Put all 0s into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;

            ans[row][col] = dist;

            for (int i = 0; i < 4; i++) {

                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n &&
                    nCol >= 0 && nCol < m &&
                    vis[nRow][nCol] == 0) {

                    vis[nRow][nCol] = 1;

                    q.add(new Pair(nRow, nCol, dist + 1));
                }
            }
        }

        return ans;
    }
}