class Solution {
    public void dfs(int [][] grid , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1){
            return ;
        }

        grid[i][j] = 1;
        dfs(grid , i , j-1);
        dfs(grid , i , j+1);
        dfs(grid , i-1 , j);
        dfs(grid , i+1 , j);
    }
    public int closedIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        // Boundary BFS problem
        // first we will make the zeros to one which are touching the boundary 

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if((i == 0 || j == 0 || i == m-1 || j == n-1 ) && grid[i][j] == 0){
                    dfs(grid , i , j);
                }
            }
        }

        int count = 0 ; // now checking for land(0) surrounded by water(1)
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0){
                    count++;
                    dfs(grid , i , j);
                }
            }
        }
        return count;

    }
}