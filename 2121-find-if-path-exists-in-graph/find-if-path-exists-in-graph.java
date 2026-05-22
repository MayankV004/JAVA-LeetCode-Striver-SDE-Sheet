class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         
        if(n==1 && source==destination) return true;

        else if(n==1 && source!=destination) return false;
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean []vis = new boolean[n];

        q.offer(source);
        vis[source] = true;

        while(!q.isEmpty()){
            int u = q.poll();

            for(int neighbour : adj.get(u)){

                if(neighbour == destination){
                    return true;
                }
                if(!vis[neighbour]){
                    q.offer(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return false;
    }
}