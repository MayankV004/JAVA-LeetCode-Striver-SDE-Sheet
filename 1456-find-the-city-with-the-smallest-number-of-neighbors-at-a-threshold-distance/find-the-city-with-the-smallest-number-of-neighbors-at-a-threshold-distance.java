class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int distance[][] = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i!=j){
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        } 

        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            distance[u][v]=w;
            distance[v][u]=w;
        }

        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE)
                    distance[i][j] = Math.min(distance[i][j] , distance[i][k] + distance[k][j]);
                }
            }
        }

        int city[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(distance[i][j] <= distanceThreshold && i!=j ){
                    city[i] += 1; 
                }
            }
        }

        int minm = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            System.out.println(city[i]);
            if(city[i] <= minm){
                minm = city[i];
                ans = i;
            }
        }

        return ans;

    }
}