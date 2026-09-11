class Solution {
    int m ; int n;
    public int maxSquare(int i , int j , int dp[][] , char matrix[][]){
        if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == '0'){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j] ;
        }

        int right = maxSquare(i , j + 1 , dp , matrix);
        int down = maxSquare(i + 1 , j , dp , matrix);
        int diag = maxSquare(i+1 , j+1 , dp , matrix);
        int maxi = 1 + Math.min(right , Math.min(down , diag));
        return dp[i][j] = maxi;
    }
    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int dp[][] = new int[m+1][n+1];

        for(int i = 0 ; i < m+1 ; i++){
            Arrays.fill(dp[i] , -1);
        }

        int maxiSq = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == '0') continue;
                int temp = maxSquare(i , j , dp , matrix);
                maxiSq = Math.max(maxiSq , temp * temp);
            }
        }

        return maxiSq;
    }
}