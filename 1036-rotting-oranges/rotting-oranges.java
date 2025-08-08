class Pair{
    int row , col , time;

    public Pair(int row , int col , int time){
        this.row = row ;
        this.col = col ; 
        this.time = time ;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length ;
        int n = grid[0].length ;
        Queue<Pair> q = new LinkedList<>();
        int [][]visited = new int[m][n];

        // counting fresh and adding rotten into the queue for initial filling of queue
        int fresh = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(grid[i][j] == 2){
                    q.offer(new Pair(i , j , 0)); // adding this to queue
                    visited[i][j] = 1; // marking visited
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        int []delRow = {0 , 0 , -1 , 1};
        int []delCol = {-1 , 1 , 0 , 0};
        int count = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.poll();

            time = Math.max(time , t); // setting new Time

            // new row and col for adjacent elements 

            for(int i = 0 ; i < 4 ; i ++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                
                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    // rotting the orange
                    q.offer(new Pair(nrow , ncol , t+1));
                    visited[nrow][ncol] = 1 ;
                    count++;
                }
            }

        }
        return count == fresh ? time : -1;

    }
}