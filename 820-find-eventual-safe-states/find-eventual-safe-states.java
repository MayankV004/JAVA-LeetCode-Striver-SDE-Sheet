class Solution {
    public boolean dfsCheck(int node , List<List<Integer>> adj , int[]visited , int[]pathVisited){
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int it : adj.get(node)){
            if(visited[it] == 0){
                if(dfsCheck(it , adj , visited , pathVisited) == false) return false;
            }else if(pathVisited[it] == 1) return false;
        }
        pathVisited[node] = 0;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int visited[] = new int[V]; 
        int pathVisited[] = new int[V];
        List<Integer> ans = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < V ; i++){
            for(int it : graph[i]){
                adj.get(i).add(it);
            }
        }

        for(int i = 0 ; i < V ; i++){
            if(visited[i] == 0){
                dfsCheck(i , adj , visited , pathVisited);
            }
        }

        for(int i = 0 ; i < V ; i++){
            if(pathVisited[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}