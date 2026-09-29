class Solution {
    int m;
    int n;

    Boolean[][][] memo;

    public boolean solve(int i, int j, char[][] grid, int balance) {

        // Out of bounds
        if (i >= m || j >= n) {
            return false;
        }

        // Process current cell
        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid path
        if (balance < 0) {
            return false;
        }

        // Destination
        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        // If there aren't enough cells left to close all '('
        int remaining = (m - 1 - i) + (n - 1 - j);

        if (balance > remaining) {
            return false;
        }

        // Memoization
        if (memo[i][j][balance] != null) {
            return memo[i][j][balance];
        }

        boolean down = solve(i + 1, j, grid, balance);
        boolean right = solve(i, j + 1, grid, balance);

        return memo[i][j][balance] = down || right;
    }

    public boolean hasValidPath(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        // Total path length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        memo = new Boolean[m][n][m + n + 1];

        return solve(0, 0, grid, 0);
    }
}