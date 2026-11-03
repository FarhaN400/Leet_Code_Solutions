class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
              mat[i][j] = matrix[i][j];
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 0){
                    mat = helper(i , j , mat);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
              matrix[i][j] = mat[i][j];
            }
        }
    }
    public int[][] helper(int x , int y , int[][] grid){
        for(int i = 0 ; i <  grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i == x || j == y){
                    grid[i][j] = 0;
                }
            }
        }
        return grid;
    }
}