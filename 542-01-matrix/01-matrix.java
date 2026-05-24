class Solution {
    static class Pair{
        int row , col ;
        Pair (int row , int col ){
            this.row = row;
            this.col = col;
            
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        Queue<Pair> q = new LinkedList<>();   

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ;j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i , j));
                }else{
                    mat[i][j] = -1; // converting one to -1 
                }
            }
        }

        // multi source BFS
        int []delRow = {0 , 0 , -1 , 1};
        int []delCol = {-1 , 1 , 0 , 0};

        while(!q.isEmpty()){
            int row = q.peek().row; // current row and colums 
            int col = q.peek().col; 
            q.poll();

            for(int k = 0 ; k < 4 ; k++){
                int nrow = row + delRow[k];
                int ncol = col + delCol[k];
                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && mat[nrow][ncol] == -1){
                    mat[nrow][ncol] = mat[row][col] + 1; 
                    q.offer(new Pair(nrow , ncol));

                }
            }
        }



        return mat;
    }
}