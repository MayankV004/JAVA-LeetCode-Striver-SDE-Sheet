class Pair{
    long dist ; int node ;
    public Pair(long dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        final long MOD = 1000000007;

        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Pair>newList = new ArrayList<>();
            graph.add(newList);
        }

        for(int[]road : roads ){
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph.get(u).add(new Pair(w,v));
            graph.get(v).add(new Pair(w,u));
        }

        long distance[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(distance , Long.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)-> Long.compare(a.dist , b.dist));

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            long dist = pq.peek().dist;
            pq.remove();

            for( Pair it : graph.get(node)){
                int adjNode = it.node;
                long adjDist = it.dist;

                //Normal Dijkstra
                if(dist + adjDist < distance[adjNode]){
                    distance[adjNode] = dist + adjDist;
                    pq.add(new Pair(dist + adjDist , adjNode));
                    ways[adjNode] = ways[node];
                }else if(dist + adjDist == distance[adjNode]){  
                    // If we reach to a node with same distance we update ways to reach their
                    ways[adjNode] = (ways[adjNode] + ways[node])%MOD;
                }
            }

        }
        return (int)(ways[n-1] % MOD);

    }
}