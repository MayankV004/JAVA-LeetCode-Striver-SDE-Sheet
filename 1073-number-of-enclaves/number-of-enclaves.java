class Solution {
    public  void dfs(int[][] grid , int i , int j , int[][] visited , int m , int n){
        // Base Case
        if( i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == 1 || grid[i][j] == 0){
            return ;
        }        
        visited[i][j] = 1; // marking visited
        grid[i][j] = 0;    // making the boundary 1s to 0 

        dfs(grid , i , j+1 , visited , m , n );
        dfs(grid , i , j-1 , visited , m , n );
        dfs(grid , i+1 , j , visited , m , n );
        dfs(grid , i-1 , j , visited , m , n );
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // first we will traverse on the boundary of grid and if there is any land on the boundary
        // then we will make it water by doing DFS 
        int visited[][] = new int[m][n];
        for (int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && grid[i][j] == 1 ){
                    dfs(grid , i , j , visited , m , n);
                }
            }
        }

        // now as well boundary land and its touching part became water , now we are only left with 
        // land surrounded by water and not touching the boundary
        //so we will just count all 1s now 
        int ans = 0 ;
        for (int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                   ans ++ ;
                }
            }
        }
        
        return ans ;
    }
}