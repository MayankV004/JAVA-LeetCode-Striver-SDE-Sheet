class Solution {
    public void BFS(Queue<int[]> q , int[][] heights , int [][] ocean){
        int m = heights.length;
        int n = heights[0].length;
        int delRow[] = {-1 , 1 , 0 , 0};
        int delCol[] = {0 , 0 , -1 , 1};

        // Doing BFS in pacific to identify the reach from the coast

        while(!q.isEmpty()){
            int []node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int i = 0 ; i < 4 ; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && 
                    heights[row][col] <= heights[nrow][ncol] && ocean[nrow][ncol] == 0 ){
                        ocean[nrow][ncol] = 1;
                        q.offer(new int[]{nrow , ncol});
                    }
            }
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        int [][] pacific= new int[m][n];
        int [][] atlantic= new int[m][n];

        Queue<int[]> queuePacific = new ArrayDeque<>();
        Queue<int[]> queueAtlantic = new ArrayDeque<>();

        for(int i = 0 ; i < m ; i++){          // marking the cells touching pacific and atlantic
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || j == 0){
                    pacific[i][j] = 1;
                    queuePacific.offer(new int[]{i , j});
                }

                if(i == m-1 || j == n-1){
                    atlantic[i][j] = 1;
                    queueAtlantic.offer(new int[]{i , j});
                }
            }
        }

        BFS(queuePacific , heights , pacific);
        BFS(queueAtlantic , heights , atlantic);

        for(int i = 0 ; i < m ; i++){         
            for(int j = 0 ; j < n ; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    result.add(Arrays.asList(i , j));
                }
            }
        }
        return result;
        
    }
}