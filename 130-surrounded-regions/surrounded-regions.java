// Problem in easy language
// Imagine the grid is a piece of land.
// 'X' represents walls.
// 'O' represents open space.
// The goal is to find all the "pools" of open space ('O') that are completely trapped by walls ('X') and fill them in (turn them into 'X').
// However, if a pool of 'O's touches the very edge of the board (top, bottom, left, or right), it is not trapped. It has an escape route to the outside. Any 'O' connected to an edge 'O' is also safe.

class Solution {
    public void dfs(char[][] board, int r, int c, int m, int n, char replace) {
        if (r < 0 || c < 0 || r > m-1 || c > n-1 || board[r][c] != 'O') {
            return;
        }

        board[r][c] = replace;

        dfs(board, r, c - 1, m, n, replace);
        dfs(board, r, c + 1, m, n, replace);
        dfs(board, r - 1, c, m, n, replace);
        dfs(board, r + 1, c, m, n, replace);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        char replace = 's';

        // Basically we will do dfs on the edges of the board and find the not surrounded region
        // and then replace the 0 with any other character while doing dfs
        // after that we will just check of replacement character and change it again back to 0/

        // left and right column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, m, n, replace);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, m, n, replace);
            }
        }

        // top and botton row
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, m, n, replace);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i, m, n, replace);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 's') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }
}