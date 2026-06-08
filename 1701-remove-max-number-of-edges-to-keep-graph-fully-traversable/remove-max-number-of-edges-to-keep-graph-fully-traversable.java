class Solution {
    class DSU {
        private int[] parent, rank;
        public int components;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;

            for (int i = 0; i < n; i++)
                parent[i] = i;
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
                return false;

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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int totalEgdesToKeep = 0;
        for(int []e : edges){
            int type = e[0];
            int u = e[1] - 1 ;
            int v = e[2] - 1;

            if (type == 3 && alice.union(u,v) && bob.union(u,v)){
                totalEgdesToKeep ++;
            }
        }

        for(int []e : edges){
            int type = e[0];
            int u = e[1] - 1 ;
            int v = e[2] - 1;

            if ((type == 1 && alice.union(u,v)) || (type == 2 && bob.union(u,v))){
                totalEgdesToKeep ++;
            }
        }

        int totalEdgesToBeRemoved = edges.length - totalEgdesToKeep;

        if(alice.components == 1 && bob.components == 1){
            return totalEdgesToBeRemoved;
        }

        return -1;
    }
}