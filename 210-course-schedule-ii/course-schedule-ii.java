class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i ++){
            graph.add(new ArrayList<>());
        }
        int indegree[]= new int[numCourses];
        for(int []pre : prerequisites){
            int u = pre[1];
            int v = pre[0];

            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
       int []toposortOrder = new int[numCourses];
       int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            toposortOrder[idx] = node;
            idx++;

            for(int neighbor : graph.get(node)){
                if(--indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        return idx == numCourses ? toposortOrder : new int[]{};


    }
}