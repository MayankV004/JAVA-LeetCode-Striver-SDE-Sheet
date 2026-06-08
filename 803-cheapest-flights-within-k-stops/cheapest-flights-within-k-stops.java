class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        int dist[] = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // using bellman ford 

        // so for k Stops we need to traverse k+1 edges 
        dist[src] = 0;
        for (int i = 0; i < k + 1; i++) { // edges relaxation
            // Snapshot : prevent using current round ’s updates within same round
            int[] prev = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];

                if (prev[u] != Integer.MAX_VALUE && prev[u] + cost < dist[v]) {
                    dist[v] = prev[u] + cost;
                }
            }
        }

        return dist[dest] != Integer.MAX_VALUE ? dist[dest] : -1;
    }
}