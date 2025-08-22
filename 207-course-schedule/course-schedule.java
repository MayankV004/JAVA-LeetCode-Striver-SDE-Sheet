class Solution {

    public boolean checkCycle(int node , List<List<Integer>> graph, int []visited , int []pathVisited){
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int it : graph.get(node)){
            if(visited[it] == 0){
                if(checkCycle( it , graph , visited , pathVisited) == false) return false;
            }else if(pathVisited[it] == 1){
                return false; // cycle found
            }
        }
        pathVisited[node] = 0;
        return true; // no cycle found
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int []visited = new int [numCourses];
        int []pathVisited = new int [numCourses];
        
        for (int i = 0 ; i < numCourses ; i++ ){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
        }

        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == 0){
                if(!checkCycle(i , graph , visited , pathVisited)) return false; 
            }
        }
        return true;

    }
}