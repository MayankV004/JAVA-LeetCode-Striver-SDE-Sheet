class Solution {
    class DSU {
        private int[] parent, rank;
        int components;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return false; // already in same component

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }

            components--;
            return true;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DSU dsu = new DSU(n);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                if(i != j && isConnected[i][j] == 1){
                    dsu.union(i , j);
                }
            }
        }

        return dsu.components;
    }
}