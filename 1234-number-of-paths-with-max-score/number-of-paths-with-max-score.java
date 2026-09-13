class Solution {
    static final int MOD = 1000000007;

    public int maxValue(int i, int j, char grid[][], int dp[][], int ways[][]) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 'X') {
            return Integer.MIN_VALUE;
        }

        if (i == 0 && j == 0) {
            ways[i][j] = 1;
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = maxValue(i - 1, j, grid, dp, ways);
        int left = maxValue(i, j - 1, grid, dp, ways);
        int diag = maxValue(i - 1, j - 1, grid, dp, ways);

        int best = Math.max(up, Math.max(left, diag));

        if (best == Integer.MIN_VALUE) {
            dp[i][j] = Integer.MIN_VALUE;
            ways[i][j] = 0;
            return Integer.MIN_VALUE;
        }
        long count = 0;
        if (up == best)
            count += ways[i - 1][j];
        if (left == best)
            count += ways[i][j - 1];
        if (diag == best)
            count += ways[i - 1][j - 1];

        ways[i][j] = (int) (count % MOD);

        // Current Cell Value
        int value = 0;
        // S and E don't contribute to score
        if (grid[i][j] != 'S' && grid[i][j] != 'E') {
            value = grid[i][j] - '0';
        }

        return dp[i][j] = best + value;
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size();
        int n = board.get(0).length();
        char grid[][] = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = board.get(i);
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int dp[][] = new int[m][n];
        int ways[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int maxSum = maxValue(m - 1, n - 1, grid, dp, ways);
        // System.out.println(maxSum);
        if (maxSum == Integer.MIN_VALUE) {
            return new int[] { 0, 0 };
        }

        return new int[] { maxSum, ways[m - 1][n - 1] };
    }
}