class NumMatrix {

    private int[][] p;

    public NumMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        p = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                p[i][j] = matrix[i - 1][j - 1]
                        + p[i - 1][j]
                        + p[i][j - 1]
                        - p[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {

        return p[r2 + 1][c2 + 1]
                - p[r1][c2 + 1]
                - p[r2 + 1][c1]
                + p[r1][c1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */