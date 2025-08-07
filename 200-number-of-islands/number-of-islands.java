class Pair{
    int first ; int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {

    private void bfs(int row , int col , int[][] visited , char grid[][]){
        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row , col));
        int n = grid.length;
        int m = grid[0].length;
        // 4 direction vectors: left, up, right, down
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        while(!q.isEmpty()){
            int x = q.peek().first;
            int y = q.peek().second;

            q.remove();

            for(int i = 0 ; i < 4 ; i++){
                
                    int nrow = x+dx[i] ;
                    int ncol = y+dy[i];

                    if( nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && 
                    visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow , ncol));
                    }
                
            }
        }
        
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int visited[][] = new int [row][col];
        int count = 0;

        for (int i = 0 ; i < row ; i++)
        {
            for(int j = 0 ; j < col ; j++)
            {
                if (visited[i][j] == 0 && grid[i][j] == '1' ){
                    count ++;
                    bfs(i , j , visited , grid);
                }
            }
        }
        return count;
    }
}