class Solution {
    public boolean checkCycle(int node , List<List<Integer>> graph , int visited[] , int pathVisited[]){
        visited[node] = 1;
        pathVisited[node] = 1;
        for(int it : graph.get(node)){
            if(visited[it] == 0){
                if(!checkCycle(it , graph , visited , pathVisited)) return false;
            }else if(pathVisited[it] == 1){
                return false; // cycle
            }
        }
        pathVisited[node] = 0;
        return true; // no cycle
    }

    public void topoSort(int node , List<List<Integer>> graph , int visited[] , Stack<Integer> st)
    {
        visited[node] = 1;
        for(int it : graph.get(node)){
            if(visited[it] == 0){
                topoSort(it , graph , visited , st);
            }
        }
        st.push(node);
    }   
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int visited[] = new int[numCourses];
        int pathVisited[] = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[]edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
        }

        boolean isCycle = false;

        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == 0){
                if(!checkCycle(i , graph , visited , pathVisited)){
                    isCycle = true; 
                } 
            }
        }

        if(isCycle){
            return (new int[0]);
        }

        for(int i = 0 ; i < numCourses ; i++){
            visited[i] = 0;
        }

        int []ans = new int[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == 0){
                topoSort(i , graph , visited , st);
            }
        }
        int i = 0;
        while(!st.isEmpty()){
            int temp = st.peek();
            st.pop();
            ans[i++] = temp; 
        }

        return ans;

    }
}