class Solution {
    int count = 0;
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};
    public void dfs(int [][]grid , boolean visited[][] , int startR ,int startC , int emptyCell){

        if(startR < 0 || startR >= grid.length || startC < 0 || startC >= grid[0].length || grid[startR][startC] == -1 || visited[startR][startC]){
            return ;
        }
        
        if(grid[startR][startC] == 2 && emptyCell == -1){
            count++;
            return ;
        }

        visited[startR][startC] = true;
         for (int i = 0; i < 4; i++) {
            int nr = startR + dr[i];
            int nc = startC + dc[i];

            dfs(grid , visited, nr , nc , emptyCell - 1 );
        }
        visited[startR][startC] = false;
    }
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length;
        int startR = -1;
        int startC = -1;
        int emptyCell = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    startR = i;
                    startC = j;
                }
                if(grid[i][j] == 0) emptyCell++;
            }
        }

        boolean visited[][] = new boolean[m][n];

        dfs(grid , visited, startR , startC , emptyCell );
        return count;

    }
}