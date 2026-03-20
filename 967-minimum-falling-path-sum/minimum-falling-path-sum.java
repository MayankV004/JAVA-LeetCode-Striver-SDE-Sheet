class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length ;

        int dp [][] = new int[m][n];

        for(int j = 0 ; j < n ; j++){  // dp initailization
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++ ){
                int up = matrix[i][j] + dp[i-1][j];
                int leftDiag = (int)1e9; // because if move it not possible the it should not affect the outcome
                int rightDiag = (int)1e9;
                if(j > 0){
                    leftDiag = matrix[i][j]+  dp[i-1][j-1];
                } 

                if(j < n-1 ){
                    rightDiag = matrix[i][j] + dp[i-1][j+1];
                }

                dp[i][j] = Math.min(up , Math.min(leftDiag , rightDiag));
            }
        }
        int ans = (int)1e9;
        for(int j = 0 ; j < n ; j++){
            System.out.println(dp[m-1][j]);
            if(dp[m-1][j] < ans){
            
                ans = dp[m-1][j];
            }
        }

        return ans;
    }
}