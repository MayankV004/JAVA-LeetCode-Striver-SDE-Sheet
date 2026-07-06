class TreeAncestor {
    private int up[][];
    private int LOG;
    public TreeAncestor(int n, int[] parent) {
        // Here we are using the concept of Binary Lifting
        LOG = (int)(Math.log(n)/Math.log(2))  + 1;
        up = new int[n][LOG];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(up[i] , -1);
        }

        // filling direct Parents
        for(int i = 0 ; i < n ; i++){
            up[i][0] = parent[i];
        }

        // filling rest of the up table with recurrence relation
        for(int j = 1 ; j < LOG ; j++){
            for(int node = 0 ; node < n ; node++){
                int prev = up[node][j-1];
                if(prev != -1){
                    up[node][j] = up[prev][j-1];
                }
            }
        }

    }
    
    public int getKthAncestor(int node, int k) {
        // now to find the kth Ancestor of node
        // we will jump in the powers of 2 of K, only jump when Bit is set to 1

        for(int j = 0 ; j < LOG ; j++){
            if((k & (1 << j) ) != 0){
                node = up[node][j];
                if(node == -1) return -1;
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */