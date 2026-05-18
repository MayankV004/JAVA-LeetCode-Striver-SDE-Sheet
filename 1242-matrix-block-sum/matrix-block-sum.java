class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int [][]prefixMat = new int[m+1][n+1]; // prefix matrix shifted by one

        for(int i = 1 ; i <= m ; i++ ){ // prefix matrix built
            for(int j = 1 ; j <= n ; j++){
                prefixMat[i][j] = mat[i-1][j-1] 
                                  + prefixMat[i-1][j] 
                                  + prefixMat[i][j-1]
                                  - prefixMat[i-1][j-1]; 
            }
        }

        int [][]answer = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int r1 = Math.max(0 , i-k);
                int c1 = Math.max(0 , j-k);

                int r2 = Math.min(m-1 , i+k);
                int c2 = Math.min(n-1 , j+k);

                r1++ ; c1++; r2++ ; c2++;

                answer[i][j] = prefixMat[r2][c2] 
                             - prefixMat[r1-1][c2]
                             - prefixMat[r2][c1-1]
                             + prefixMat[r1-1][c1-1];
            }
        }

        return answer;
    }
}