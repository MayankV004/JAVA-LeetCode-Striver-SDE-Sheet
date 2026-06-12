class Solution {
    //T.C : O(E logV) - where E = number of edges and V = number of vertices
    //S.C : O(V+E)
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int []edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        Arrays.fill(d1 , Integer.MAX_VALUE);
        Arrays.fill(d2 , Integer.MAX_VALUE);


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0 , 1});
        d1[1] = 0;

        while(!pq.isEmpty())
        {
            int []curr = pq.poll();
            int timePassed = curr[0];
            int node = curr[1];
            // We reached n 2nd time means it's the second minimum
            if(node == n && d2[n] != Integer.MAX_VALUE)
            {
                return d2[n];
            }

            int mult = timePassed / change;
            if(mult % 2 == 1) // ODD : Red
            {
                timePassed = change * (mult + 1); // to set Green
            }

            for(int neighbour : graph.get(node))
            {
                if(d1[neighbour] > timePassed + time)// +time for this edge to reach nbr
                {
                    d2[neighbour] = d1[neighbour];
                    d1[neighbour] = timePassed + time ;
                    pq.offer(new int[]{timePassed + time , neighbour});
                }
                else if(d2[neighbour] > timePassed + time && d1[neighbour] != timePassed + time)
                {
                    d2[neighbour] = timePassed + time;
                    pq.offer(new int[]{timePassed + time , neighbour});
                }
            }
        }
        return -1;
    }
}
//Approach-2 (Using BFS)
//T.C : O(V + E) - where E = number of edges and V = number of vertices
//S.C : O(V+E)
// class Solution {
//     public int secondMinimum(int n, int[][] edges, int time, int change) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];
//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }

//         int[] d1 = new int[n + 1];
//         int[] d2 = new int[n + 1];
//         Arrays.fill(d1, Integer.MAX_VALUE);
//         Arrays.fill(d2, Integer.MAX_VALUE);

//         Queue<int[]> que = new LinkedList<>();
//         que.offer(new int[]{1, 1}); // Visited node 1 once
//         d1[1] = 0;

//         while (!que.isEmpty()) {
//             int[] curr = que.poll();
//             int node = curr[0];
//             int freq = curr[1];

//             int timePassed = (freq == 1) ? d1[node] : d2[node];
//             if (d2[n] != Integer.MAX_VALUE && node == n) { // We reached n 2nd time means it's the second minimum
//                 return d2[n];
//             }

//             int mult = timePassed / change;
//             if (mult % 2 == 1) { // Red light
//                 timePassed = change * (mult + 1); // to set green
//             }

//             for (int nbr : adj.get(node)) {
//                 if (d1[nbr] == Integer.MAX_VALUE) {
//                     d1[nbr] = timePassed + time;
//                     que.offer(new int[]{nbr, 1});
//                 } else if (d2[nbr] == Integer.MAX_VALUE && d1[nbr] != timePassed + time) {
//                     d2[nbr] = timePassed + time;
//                     que.offer(new int[]{nbr, 2});
//                 }
//             }
//         }
//         return -1;
//     }
// }