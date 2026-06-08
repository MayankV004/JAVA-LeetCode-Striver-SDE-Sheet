class Solution {
    class DSU {
        private int[] parent , rank;

        DSU(int n ){
            this.parent = new int[n];
            this.rank = new int[n];

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

            if(px == py) return false;

            if(rank[px] < rank[py]) parent[px] = py;
            else if(rank[px] > rank[py]) parent[py] = px;
            else{
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        // Krushkals MST
        int n = points.length;

        List<int[]> edges = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int cost = Math.abs(x1-x2) + Math.abs(y1-y2);

                edges.add(new int[]{cost , i , j});

            }
        }

        // as in Krushkals we start with Egde of minimum Weight

        // sorting edges by weight
        Collections.sort(edges , (a,b) -> a[0] - b[0]);

        DSU dsu = new DSU(n);

        int totalCost = 0;

        int edgesVisited = 0;

        for(int []e : edges){
            int cost = e[0];
            int u = e[1];
            int v = e[2];

            if(dsu.union(u,v)){
                totalCost += cost;
                edgesVisited++;
            }

            if(edgesVisited == n-1) break;
        }

        return totalCost;
    }   
}