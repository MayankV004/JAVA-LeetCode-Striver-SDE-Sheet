class Solution {
    int m , n ;
    public int solve(int i , int j , int t[][] , int matrix[][]){

        if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 0){
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        int right = solve(i , j+1 , t , matrix);
        int down = solve(i+1 , j , t , matrix);
        int diag = solve(i+1 , j+1 , t , matrix);

        return t[i][j] = 1 + Math.min(right , Math.min(down , diag));
    }
    public int countSquares(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int t[][] = new int[m+1][n+1];
        for(int i = 0 ; i <= m ; i++){
            Arrays.fill(t[i] , -1);
        }

        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                ans += solve(i ,j, t , matrix);
            }
        }
        
        return ans;
    }
}