class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] communicate = new boolean[n][m];

        // Check every row
        for(int i = 0; i < n; i++) {

            int count = 0;

            // Count servers in this row
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }

            // If more than one, mark them
            if(count > 1) {
                for(int j = 0; j < m; j++) {
                    if(grid[i][j] == 1) {
                        communicate[i][j] = true;
                    }
                }
            }
        }

        // Check every column
        for(int j = 0; j < m; j++) {

            int count = 0;

            // Count servers in this column
            for(int i = 0; i < n; i++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }

            // If more than one, mark them
            if(count > 1) {
                for(int i = 0; i < n; i++) {
                    if(grid[i][j] == 1) {
                        communicate[i][j] = true;
                    }
                }
            }
        }

        int cnt = 0;

        // Count marked servers
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(communicate[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}