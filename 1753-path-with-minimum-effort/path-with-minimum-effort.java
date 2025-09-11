class Pair{
    int wt ; int row ; int col ;
    Pair(int wt , int  row , int col){
        this.wt  = wt ;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int dist[][] = new int[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
                
        dist[0][0] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.wt - b.wt);
        pq.add(new Pair(0 , 0, 0));
        
        int delRow[] = {0,0,1,-1};
        int delCol[] = {1,-1,0,0};
        
        while(!pq.isEmpty()){
            int distance = pq.peek().wt;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();
            
            if(row == n-1 && col == m-1){
                return distance;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m ){
                    int newEffort = Math.max(Math.abs(heights[nrow][ncol] - heights[row][col] ), distance);
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Pair(dist[nrow][ncol] , nrow , ncol));
                    }

                }
            }
            
        }
        return 0;
                
    }
}