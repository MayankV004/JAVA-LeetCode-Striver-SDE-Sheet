//BFS solution
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1)
            return informTime[headID];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Graph built
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        // BFS queue -> {employeeID, currentTime}
        q.offer(new int[] { headID, 0 });

        int ans = 0;
        while (!q.isEmpty()) {
            int employee[] = q.poll();
            int employeeID = employee[0];
            int time = employee[1];

            ans = Math.max(ans, time);

            for (int subordinate : graph.get(employeeID)) {
                q.offer(new int[] { subordinate, time + informTime[employeeID] });
            }
        }

        return ans;

    }
}

// DFS solution

// class Solution {

//     public int dfs(int employee, List<List<Integer>> adj, int[] informTime) {
//         int maxTime = 0;
//         // Visit all subordinates
//         for (int child : adj.get(employee)) {
//             maxTime = Math.max(maxTime, dfs(child, adj, informTime));
//         }
//         return informTime[employee] + maxTime;
//     }

//     public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//         List<List<Integer>> adj = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < n; i++) {
//             if (manager[i] != -1) {
//                 adj.get(manager[i]).add(i);
//             }
//         }

//         return dfs(headID, adj, informTime);
//     }
// }