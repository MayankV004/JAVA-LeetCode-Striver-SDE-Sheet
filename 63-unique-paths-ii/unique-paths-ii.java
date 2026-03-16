class Solution {

    public int uniquePathII(int i , int j , int [][]obstacleGrid , int dp[][]){
        
        if(i < 0 || j < 0 || obstacleGrid[i][j] == 1){
            return 0 ;
        }

        if( i == 0 && j == 0){
            return 1; // found 1 path 
        }

        if(dp[i][j] != -1) return dp[i][j] ;

        int up = uniquePathII(i-1 , j , obstacleGrid , dp);
        int left = uniquePathII(i , j-1 , obstacleGrid , dp);

        return dp[i][j] =up + left;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];

        for(int i = 0 ; i < m ; i ++){
            Arrays.fill(dp[i] , -1);
        }

        return uniquePathII(m-1 , n-1 , obstacleGrid , dp);

    }
}