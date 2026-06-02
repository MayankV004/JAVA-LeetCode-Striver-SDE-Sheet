class Solution {
    int max = 0;
    public void dfs(int[]edges , int[]visited , int[]pathVisited , int[]distanceFromStart , int currentNode){
        visited[currentNode] = 1;
        pathVisited[currentNode] = 1;

        int neighbor = edges[currentNode];

        if(neighbor != -1){
            if(visited[neighbor] == 0){ // visiting the neighbor 
                // increasing the length
                distanceFromStart[neighbor] = distanceFromStart[currentNode] + 1;
                // visited it 
                dfs(edges , visited , pathVisited , distanceFromStart , neighbor);
            }else if(pathVisited[neighbor] == 1){// cycle found
                int cycleLength = distanceFromStart[currentNode] - distanceFromStart[neighbor] + 1;
                // calculating max cycle length
                max = Math.max(max , cycleLength);
            }
        }

        pathVisited[currentNode] = 0;

    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int visited[] = new int[n];
        int distanceFromStart [] = new int[n];

        int pathVisited[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                dfs(edges , visited , pathVisited, distanceFromStart, i);
            }
        }

        return max == 0 ? -1 : max; 
    }
}