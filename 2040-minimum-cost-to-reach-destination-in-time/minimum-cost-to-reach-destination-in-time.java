class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        int n = passingFees.length;

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int t = e[2];

            graph[u].add(new int[] { v, t });
            graph[v].add(new int[] { u, t });
        }

        int[][] dist = new int[n][maxTime + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = passingFees[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // {cost, node, time}
        pq.offer(new int[] { passingFees[0], 0, 0 });

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int time = curr[2];

            if (node == n - 1) {
                return cost;
            }

            if (cost > dist[node][time]) {
                continue;
            }

            for (int[] nbr : graph[node]) {

                int nextNode = nbr[0];
                int travelTime = nbr[1];

                int newTime = time + travelTime;

                if (newTime > maxTime)
                    continue;

                int newCost = cost + passingFees[nextNode];

                if (newCost < dist[nextNode][newTime]) {

                    dist[nextNode][newTime] = newCost;

                    pq.offer(new int[] {
                            newCost,
                            nextNode,
                            newTime
                    });
                }
            }
        }

        return -1;
    }
}