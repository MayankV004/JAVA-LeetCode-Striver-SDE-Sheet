class Solution {

    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<Pair> q = new LinkedList<>();

        // Step 1:
        // Push all 0s into queue
        // Convert all 1s into -1

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new Pair(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[] delRow = { 0, 0, -1, 1 };
        int[] delCol = { -1, 1, 0, 0 };

        // Step 2:
        // Multi Source BFS

        while (!q.isEmpty()) {

            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();

            // Explore all 4 directions

            for (int k = 0; k < 4; k++) {

                int nrow = row + delRow[k];
                int ncol = col + delCol[k];

                // Valid unvisited neighbour

                if (nrow >= 0 && ncol >= 0 &&
                        nrow < m && ncol < n &&
                        mat[nrow][ncol] == -1) {

                    // Distance of neighbour
                    // = current distance + 1

                    mat[nrow][ncol] = mat[row][col] + 1;

                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        return mat;
    }
}

/*
---------------------------------- EXPLANATION ----------------------------------

PROBLEM:
For every cell containing 1,
find the distance to the nearest 0.

Distance is measured in 4 directions:
up, down, left, right.


-------------------------------------------------------------------------------
BRUTE FORCE APPROACH
-------------------------------------------------------------------------------

For every 1:
    Run BFS until a 0 is found.

Time Complexity:
O((m*n) * (m*n))

because BFS may traverse entire matrix for every cell.

This gives TLE.


-------------------------------------------------------------------------------
OPTIMAL APPROACH : MULTI SOURCE BFS
-------------------------------------------------------------------------------

Instead of:
    "From every 1 find nearest 0"

We do:
    "From all 0s spread distances simultaneously"

This is called Multi Source BFS.


-------------------------------------------------------------------------------
KEY OBSERVATION
-------------------------------------------------------------------------------

All 0s are sources.

The first time BFS reaches a cell,
that distance is guaranteed to be the shortest.

Why?

Because BFS explores level by level.


-------------------------------------------------------------------------------
WHY CONVERT 1 -> -1 ?
-------------------------------------------------------------------------------

Original matrix contains only:
0 and 1

So we convert:
1 -> -1

Meaning:
-1 = unvisited cell

Now matrix itself acts as:
1. visited array
2. distance array

This avoids extra space.


-------------------------------------------------------------------------------
ALGORITHM
-------------------------------------------------------------------------------

STEP 1:
Push all 0s into queue.

Convert all 1s into -1.


Example:

1 1 1
1 0 1
1 1 1

becomes:

-1 -1 -1
-1  0 -1
-1 -1 -1


-------------------------------------------------------------------------------
STEP 2:
Run BFS from all 0s simultaneously.
-------------------------------------------------------------------------------

When visiting neighbours:

If neighbour == -1:
    It means unvisited.

Assign:
    neighbour distance = current distance + 1

Then push neighbour into queue.


-------------------------------------------------------------------------------
HOW DISTANCES SPREAD
-------------------------------------------------------------------------------

Initially:

-1 -1 -1
-1  0 -1
-1 -1 -1


After first BFS layer:

-1  1 -1
 1  0  1
-1  1 -1


After second BFS layer:

2 1 2
1 0 1
2 1 2


-------------------------------------------------------------------------------
TIME COMPLEXITY
-------------------------------------------------------------------------------

Each cell is visited only once.

Time Complexity:
O(m * n)

Space Complexity:
O(m * n) for queue


-------------------------------------------------------------------------------
IMPORTANT BFS PATTERN
-------------------------------------------------------------------------------

Whenever problem says:

- nearest source
- nearest hospital
- nearest gate
- nearest zero
- spread of fire/infection

Think:
MULTI SOURCE BFS

-------------------------------------------------------------------------------
*/