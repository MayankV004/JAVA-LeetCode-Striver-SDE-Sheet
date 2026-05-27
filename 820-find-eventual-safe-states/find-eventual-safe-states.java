class Solution {

    public boolean dfs(int [][]graph , int currNode , int[]state){
        if(state[currNode] == 1){ 
            // means there is cycle so not safe
            return false; 
        }
        if(state[currNode] == 2){
            // it is a safe node 
            return true;
        }

        // in starting we make the node unsafe
        state[currNode] = 1;

        for(int neighbor : graph[currNode]){
            if(!dfs(graph , neighbor, state)){
                return false;
            }
        }
        state[currNode] = 2; // marking it safe on backtracking 
        // as we have found a terminal node 

        return true;

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int state[] = new int[n]; // keeping the track of states 
        // state = 0 -> unvisited
        // state = 1 -> visited and not safe
        // state = 2 -> safe

        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(dfs(graph , i , state)){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}