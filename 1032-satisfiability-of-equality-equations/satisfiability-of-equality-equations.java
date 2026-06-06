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

        public boolean connected(int x , int y){
            return find(x) == find(y);
        }
    }
    public boolean equationsPossible(String[] equations) {
        // Making DSU of size 26 as there are 26 Character present

        DSU dsu = new DSU(26);

        // doing union of == equations as they belong to same component
        for(String eq : equations){
            if(eq.charAt(1) == '=' && eq.charAt(2) == '='){
                dsu.union(eq.charAt(0) - 'a' , eq.charAt(3) - 'a');
            }
        }

        // now checking that if x!=y then they should not be in same component or Disjoint set
        for(String eq : equations){
            if(eq.charAt(1) == '!' && eq.charAt(2) == '='){
                if(dsu.connected(eq.charAt(0) - 'a' , eq.charAt(3) - 'a')){
                    return false; // if they are in same component dispite of not equality then -> all equations dont satisfy 
                }
            }
        }
        return true;
    }
}