class Pair{
    int node , distance , stop;
    Pair(int node , int distance , int stop){
        this.node = node;
        this.distance = distance;
        this.stop = stop;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        int []dist = new int[n];
  
        Arrays.fill(dist , Integer.MAX_VALUE);
    
        dist[src] = 0;
  
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        // Graph Creation
        for(int []flight : flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph.get(u).add(new Pair(v ,  w , 0));
        }

        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src , 0 , 0));

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int cost = pq.peek().distance;
            int stop = pq.peek().stop;
            pq.remove();
            if(stop > k) continue;

            for(Pair neighbour : graph.get(node)){
                int neigh = neighbour.node;
                int wt = neighbour.distance;
                int halt = neighbour.stop;

                if(wt + cost < dist[neigh] && stop <= k ){
                    dist[neigh] = wt + cost;
                    pq.add(new Pair(neigh , dist[neigh] , stop + 1 ));
                }

            }

        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;

        return dist[dst];
        
    }
}