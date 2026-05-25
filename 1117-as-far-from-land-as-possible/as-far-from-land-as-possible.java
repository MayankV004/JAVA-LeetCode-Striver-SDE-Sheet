class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
            {
                if(grid[i][j] == 1){
                    q.offer(new int[]{i , j , 1});
                }
            }
        }
        int[] delRow = { 0, 0, -1, 1 };
        int[] delCol = { -1, 1, 0, 0 };
        int distance = Integer.MIN_VALUE;
        int visited[][] = new int[n][n];
        while(!q.isEmpty()){
            int []node = q.poll();
            int row = node[0];
            int col = node[1];
            int dist = node[2];

            for(int i = 0 ; i < 4 ; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 0){
                    visited[nrow][ncol] = 1;
                    q.offer(new int[]{nrow , ncol , dist+1});
                    distance = Math.max(distance , dist+1);
                }
            }

        }
        return distance == Integer.MIN_VALUE ? -1 : distance - 1 ;
    }
}