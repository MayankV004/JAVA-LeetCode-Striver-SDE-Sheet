class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if( n == 0) {
            return res;
        }

        if(n == 1){
            res.add(0);
            return res;
        }

        int degree[] = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0]; int v = edge[1];
            degree[u]++; degree[v]++;

            graph.get(u).add(v);
            graph.get(v).add(u);

        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            if(degree[i] == 1){ // adding leaf nodes in queue
                q.offer(i);
            }
        }

        while(n > 2){
            int qSize = q.size();

            n -= qSize;

            while( qSize-- > 0){
                int node = q.poll();

                for(int neighbor : graph.get(node)){
                    degree[neighbor]-- ;

                    if(degree[neighbor] == 1){
                        q.offer(neighbor);
                    }
                }
            }
        }

        res.addAll(q);
        return res;
    }
}