class Solution {
    int m , n;
    public int solve(int i , int j , int dp[][] , int matrix[][]){
        if(j < 0 || j >= n ){
            return Integer.MAX_VALUE;
        }
        if(i == m-1){
            return matrix[i][j];
        }
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int leftDiag = solve( i+1 , j-1 , dp , matrix);
        int down = solve( i+1 , j , dp , matrix);
        int rightDiag = solve( i+1 , j+1 , dp , matrix);

        return dp[i][j] = matrix[i][j] + Math.min(rightDiag , Math.min(leftDiag , down));
    }
    public int minFallingPathSum(int[][] matrix) { 
        m = matrix.length;
        n = matrix[0].length;

        int dp[][] = new int[m][n];

        for(int i = 0 ; i < m ;i++){
            Arrays.fill(dp[i] , Integer.MAX_VALUE);
        }

        int mini = Integer.MAX_VALUE;
        for(int j = 0 ; j < n ; j++){
            mini = Math.min(mini , solve(0 , j , dp , matrix));
        }

        return mini;
    }
}