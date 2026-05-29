class Solution {

    public void dfs(int [][]graph , int currentNode , int dest , List<Integer> currentPath , List<List<Integer>> ans){

        if(currentNode == dest){
            // We MUST create a new ArrayList. 
            // Otherwise, we are just adding a reference to currentPath, 
            // which will be modified and emptied by subsequent backtracking.
            ans.add(new ArrayList<>(currentPath));
            return ;
        }

        for(int neighbor : graph[currentNode]){
            currentPath.add(neighbor); //choosing the neighbor
            dfs(graph , neighbor , dest , currentPath , ans); // exploring the path
            currentPath.remove(currentPath.size() - 1); // on return we remove elements from last
            // as we will be reusing this currentPath array again for alternative paths
        }


    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        int src = 0;
        int dest = graph.length - 1;

        currentPath.add(src); // as source will be in paths
        dfs(graph , src , dest , currentPath , ans );

        return ans;
    }
}