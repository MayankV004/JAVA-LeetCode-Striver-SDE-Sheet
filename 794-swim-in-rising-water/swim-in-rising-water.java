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

/*
APPROACH (DSU / UNION FIND)

Idea:
At time t, all cells having elevation <= t become available.

Instead of checking every possible path, we activate cells in
increasing order of elevation and connect neighboring active cells
using DSU.

The first time the start cell and destination cell become part of
the same connected component, that time is the answer.


Step 1: Build pos array

pos[elevation] = {row, col}

Example:
grid[2][1] = 13

Then:
pos[13] = {2,1}

This allows us to instantly find which cell becomes active
at a particular time.


Step 2: Activate cells in increasing elevation order

for(time = 0 -> n*n-1)

At each time:
- Find the cell whose elevation equals time.
- Mark it as active.


Step 3: Convert 2D coordinates to DSU node

DSU works on 1D indices.

Formula:
id = row * n + col

Example (n = 3):

(0,0) -> 0
(0,1) -> 1
(0,2) -> 2
(1,0) -> 3
(1,1) -> 4
(1,2) -> 5


Step 4: Connect active neighbors

For every newly activated cell:
- Check its 4 neighbors.
- If a neighbor is already active,
  union(currentCell, neighborCell).

This gradually builds connected components
of reachable cells.


Step 5: Check connectivity

Start cell:
(0,0)
id = 0

Destination cell:
(n-1,n-1)
id = (n-1)*n + (n-1)
   = n*n - 1

Condition:

dsu.isConnected(0, n*n - 1)

If true:
- A path exists from start to destination.
- Since elevations are processed in increasing order,
  current time is the minimum water level required.

Return current time.


Time Complexity:
O(n²)

Space Complexity:
O(n²)
*/