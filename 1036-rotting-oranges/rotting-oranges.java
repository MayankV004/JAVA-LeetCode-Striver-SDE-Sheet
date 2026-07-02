class Solution {
    public int orangesRotting(int[][] grid) {
        
        int fresh = 0;
        int m = grid.length ;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int visited[][] = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++ ){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i , j , 0}); // row , col , time
                    visited[i][j] = 1;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        // Multi source BFS
        int directions[][] = { {-1 , 0} , {1 , 0}, {0 , -1} , { 0 , 1}}; // all four directions
        int countRotten = 0;
        int ans = 0;
        while(!q.isEmpty()){
            int current[] = q.poll();

            int row = current[0];
            int col = current[1];
            int time = current[2];
            ans = Math.max(ans , time);
            for(int dirs[] : directions){
                int nr = row + dirs[0];
                int nc = col + dirs[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && visited[nr][nc] == 0 && grid[nr][nc] == 1){
                    countRotten++;
                    visited[nr][nc] = 1;
                    q.offer(new int[]{nr , nc , time+1});
                }
            }

        }

        return countRotten == fresh ? ans : -1;
    }
}