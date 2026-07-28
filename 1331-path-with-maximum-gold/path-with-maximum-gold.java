class Solution {
    int maxi = 0;
    public void dfs(int [][]grid , int i , int j  , int sum  , boolean [][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0 ){
            return ;
        }
        visited[i][j] = true;
        sum += grid[i][j];
        maxi = Math.max(maxi , sum);

        dfs(grid , i+1 , j , sum , visited);
        dfs(grid , i-1 , j , sum , visited);
        dfs(grid , i , j+1 , sum , visited);
        dfs(grid , i , j-1 , sum , visited);
        
        visited[i][j] = false;
    }
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != 0){
                    dfs(grid , i , j  , 0 , visited);
                }
            }
        }

        return maxi;
    }
}