class NumMatrix {

    // Prefix sum matrix
    // p[i][j] stores sum of rectangle:
    // (0,0) -> (i-1,j-1)
    //
    // Extra row and column are added
    // to avoid boundary checks.
    private int[][] p;

    public NumMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // (m+1) x (n+1) prefix matrix
        p = new int[m + 1][n + 1];

        // Build prefix sum matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // Current cell value
                // + upper prefix
                // + left prefix
                // - overlap counted twice
                p[i][j] =
                        matrix[i - 1][j - 1]
                        + p[i - 1][j]
                        + p[i][j - 1]
                        - p[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {

        // Inclusion-Exclusion Principle
        //
        // total rectangle
        // - upper extra area
        // - left extra area
        // + overlap removed twice
        //
        // NOTE:
        // Prefix matrix is shifted by +1,
        // so indices become:
        // (r2+1, c2+1)

        return p[r2 + 1][c2 + 1]
                - p[r1][c2 + 1]
                - p[r2 + 1][c1]
                + p[r1][c1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 *
 * NumMatrix obj = new NumMatrix(matrix);
 * int ans = obj.sumRegion(row1, col1, row2, col2);
 */