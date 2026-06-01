class Solution {

    public int[] findBoundary(int color , int [][]grid){
        int minRow = grid.length + 1;
        int maxRow = -1 ;
        int minCol = grid[0].length +1 ;
        int maxCol = -1;

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == color){
                    minRow = Math.min(minRow , i);
                    maxRow = Math.max(maxRow , i);

                    minCol = Math.min(minCol , j);
                    maxCol = Math.max(maxCol , j);
                }
            }
        }

        return new int[]{minRow , maxRow , minCol , maxCol};
    }

    public boolean otherColorInBoundary(int color , int[] boundary , int[][] grid ){
        int minRow = boundary[0];
        int maxRow = boundary[1];
        int minCol = boundary[2];
        int maxCol = boundary[3];

        for(int i = minRow ; i <= maxRow ; i++){
            for(int j = minCol ; j <= maxCol ; j++){
                if(grid[i][j] == color){
                    return true;
                }
            }
        }

        return false;

    }


    public boolean isPrintable(int[][] targetGrid) {
        Set<Integer> set = new HashSet<>();
        List<Set<Integer>> graph = new ArrayList<>();

        int m = targetGrid.length;
        int n = targetGrid[0].length;

        int maxColor = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                set.add(targetGrid[i][j]);
                maxColor = Math.max(maxColor , targetGrid[i][j]);
            }
        }

        maxColor = maxColor + 1; // for 1-indexed array

        int indegree[] = new int[maxColor];

        for(int i = 0 ; i < maxColor ; i++){
            graph.add(new HashSet<>());
            indegree[i] = -1 ; // setting -1 for not real colors
        }

        for(int color : set ){
            indegree[color] = 0; // setting 0 for real actual colors
        }

        // building Graph
        for(int color : set){
            // getting the boundary points for the particular color
            int boundary[] = findBoundary(color , targetGrid);

            for(int otherColor : set ){
                if((otherColor != color) && otherColorInBoundary(otherColor , boundary , targetGrid)){
                    if(!graph.get(color).contains(otherColor)){
                        graph.get(color).add(otherColor);
                        indegree[otherColor]++;
                    }
                }
            }

        }

        // now BFS using kahns algo

        Queue<Integer> q = new ArrayDeque<>();

        // added starting points in the queue
        for(int i = 0 ; i < maxColor ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int processed = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            processed ++;

            for(int neighbor : graph.get(node)){
                if(--indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        return processed == set.size();


    }
}