class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dist [][] = new int [m][n];

        for(int i = 0 ; i < m ; i++){
            Arrays.fill(dist[i] , Integer.MAX_VALUE);
        }   

        int dr[] = { 0 , 0 ,0 ,1 ,-1};
        int dc[] = { 0 , 1 , -1 , 0 , 0};

        Deque<int[]> dq = new ArrayDeque<>();

        dist[0][0] = 0;
        dq.addFirst(new int[]{0 , 0});

        while(!dq.isEmpty()){
            int []curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];

            for(int i = 1 ; i<= 4 ; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n ){
                    continue;
                }

                int cost = (grid[r][c] == i) ? 0 : 1;

                int newCost = dist[r][c] + cost;

                if(newCost < dist[nr][nc]){
                    dist[nr][nc] = newCost;

                    if(cost == 0){
                        dq.addFirst(new int[]{nr , nc});
                    }else{
                        dq.addLast(new int[]{nr , nc});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}