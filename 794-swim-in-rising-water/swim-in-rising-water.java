class Solution {
    class DSU{
        private int[] parent , rank;
        
        public DSU(int n ){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }    
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x , int y){
            int px = find(x);
            int py = find(y);

            if(px == py) return false ; 

            if(rank[px] < rank[py]){
                parent[px] = py;
            }else if(rank[px] > rank[py]){
                parent[py] = px;
            }else{
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }

        public boolean isConnected(int x , int y){
            return find(x) == find(y);
        }


    }
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        
        int [][] pos = new int[n*n][2];

        // postion(12) -> (0,2) like that 

        for(int i = 0 ; i < n ; i++){ 
            for(int j = 0 ; j < n ; j++){
                pos[grid[i][j]][0] = i;
                pos[grid[i][j]][1] = j;
            }
        }

        DSU dsu = new DSU(n*n);

        boolean active[][] = new boolean[n][n];

        int [][]directions ={{-1 , 0} , {1 , 0}, {0 , -1} , {0 , 1}};

        for(int time = 0 ; time < n*n ; time++){

            int row = pos[time][0];
            int col = pos[time][1];

            active[row][col] = true;

            int currentId = row * n + col;

            for(int []dir : directions){
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < n && active[nrow][ncol] == true ){
                    int neighborId = nrow * n + ncol;
                    dsu.union(currentId , neighborId);
                }
            }

            // important Comdition Explanation
            // start -> (0,0) -> 0 * n + 0 = 0
            // destination -> (n-1 , n-1) - > (n-1) * n + (n-1)-> n^2 - n + n - 1 -> n*n-1 

            if(dsu.isConnected(0 , n*n-1)){ 
                return time;
            }
        }
        return -1;
    }
}