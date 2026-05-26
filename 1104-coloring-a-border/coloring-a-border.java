class Solution {
    public void dfs(int[][] grid, int row, int col, int color, int originalColor , int[][]result , int[][]visited){
        int m = grid.length;
        int n = grid[0].length;
        if(row < 0 || col < 0 || row >= m|| col >= n|| visited[row][col] == 1 ){
            return ;
        }

        visited[row][col] = 1;

        //not part of connected component check
        if(grid[row][col] != originalColor) return ;

        boolean isBorderCell = false;

        //checking for boundary 
        if(row == 0 || col == 0 || row == m-1 || col == n-1){
            isBorderCell = true;
        }

        // now checking all 4 direction 
        int[] delRow = { 0, 0, -1, 1 };
        int[] delCol = { -1, 1, 0, 0 };

        for(int i = 0 ; i < 4 ; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && grid[nrow][ncol] != originalColor){
                isBorderCell = true;
            }

        }

        // now marking border cell 
        if(isBorderCell){
            result[row][col] = 1;
        }

        dfs(grid , row , col-1 , color , originalColor , result , visited);
        dfs(grid , row , col+1 , color , originalColor , result , visited);
        dfs(grid , row-1 , col , color , originalColor , result , visited);
        dfs(grid , row+1 , col , color , originalColor , result , visited);
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int originalColor = grid[row][col];
        int result[][] = new int[m][n];
        int visited[][] = new int[m][n];

        dfs(grid , row , col , color , originalColor , result , visited);

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(result[i][j] == 1){
                    grid[i][j] = color;
                }
            }
        }

        return grid;    
    }
}