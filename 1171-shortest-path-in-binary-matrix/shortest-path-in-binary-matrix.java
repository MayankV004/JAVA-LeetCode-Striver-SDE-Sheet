class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();

        if(grid[0][0] == 0){
            q.offer(new int[]{0 , 0 , 1});
        }

        if(grid.length == 1 ){
            if(grid[0][0] == 0) return 1;
            else return -1;
        }

        int [] delRow = {-1 , -1 , - 1 , 0 , 0 , 1 , 1 , 1 }; // all 8 directions 
        int [] delCol = {-1 ,  0 , 1 , -1 ,  1 , -1 , 0 ,1 };
        int visited[][] = new int[n][n];
        while(!q.isEmpty()){
            int []node = q.poll();

            int row = node[0];
            int col = node[1];
            int dist = node[2];
            if(row == n-1 && col == n-1){
                return dist ;
            }
            for(int i = 0 ; i < 8 ; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 0){
                    visited[nrow][ncol] = 1;
                    q.offer(new int[]{nrow , ncol , dist + 1});
                }
            }

        }
        return -1;
    }
}