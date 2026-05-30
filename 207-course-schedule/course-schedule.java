class Solution {
    public boolean checkCycle(int node, List<List<Integer>> graph, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int it : graph.get(node)) {
            if (visited[it] == 0) {
                if (checkCycle(it, graph, visited, pathVisited) == false)
                    return false;
            } else if (pathVisited[it] == 1) {
                return false; // cycle found
            }
        }
        pathVisited[node] = 0;
        return true; // no cycle found
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!checkCycle(i, graph, visited, pathVisited))
                    return false;
            }
        }
        return true;

    }
}

// using kahn's algorithm (Topological Sort BFS)
// to detect cycle -> we should be getting a toposort order 
// if we did not get the order result.size() != number of nodes -> cycle is there 
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {   
//         List<List<Integer>> graph = new ArrayList<>();

//         for(int i = 0 ; i < numCourses ; i++){
//             graph.add(new ArrayList<>());
//         }

//         int []indegree = new int[numCourses];

//         for(int []prerequisite : prerequisites){
//             int u = prerequisite[1];
//             int v = prerequisite[0];
//             graph.get(u).add(v);
//             indegree[v]++;
//         }

//         Queue<Integer> q = new ArrayDeque<>();
//         // pushing all nodes with indegree zero 
//         // as they can be put at the starting of the toposort
//         for(int i = 0 ; i < numCourses ; i++){
//             if(indegree[i] == 0){
//                 q.offer(i);
//             }
//         }

//         int nodesProcessed = 0;
//         while(!q.isEmpty()){
//             int node = q.poll();
//             nodesProcessed++;

//             for(int neighbor : graph.get(node)){
//                 // reducing the indgree
//                 indegree[neighbor]--;
//                 if(indegree[neighbor] == 0){
//                     q.offer(neighbor);
//                 }
//             }
//         }

//         return nodesProcessed == numCourses ? true : false;

//     }
// }
