// using kahn's algorithm (Topological Sort BFS)
// to detect cycle -> we should be getting a toposort order 
// if we did not get the order result.size() != number of nodes -> cycle is there 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {   
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        int []indegree = new int[numCourses];
        
        for(int []prerequisite : prerequisites){
            int u = prerequisite[1];
            int v = prerequisite[0];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int nodesProcessed = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            nodesProcessed++;

            for(int neighbor : graph.get(node)){
                // reducing the indgree
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        
        return nodesProcessed == numCourses ? true : false;
        
    }
}