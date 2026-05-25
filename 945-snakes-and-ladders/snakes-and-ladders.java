// Approach 1
// class Solution {
//     public int[] getCoordinate(int cell , int n ){
//         int rowFromBottom = (cell - 1) / n;
//         int row = n - 1 - rowFromBottom;
//         int col = (cell - 1) % n;

//         if(rowFromBottom % 2 != 0){ // reverse direction on odd rows from bottom
//             col = n - 1 -col;
//         }

//         return new int[]{row , col};
//     }
//     public int snakesAndLadders(int[][] board) {
//         int n = board.length;
//         Queue<int[]> q = new ArrayDeque<>();
//         q.offer(new int[]{1 , 0}); // cell, moves

//         boolean visited[] = new boolean[n * n + 1]; // so for n=6 -> n*n = 36 -> array will be 0 to 35 thats why added 1
//         visited[1] = true;

//         while(!q.isEmpty()){
//             int node[] = q.poll();
//             int currCell = node[0];
//             int moves = node[1];

//             if(currCell == n*n) return moves;

//             for(int dice = 1 ; dice <= 6 ; dice++ ){
//                 int nextCell = currCell + dice;

//                 if(nextCell > n*n ) break;

//                 // now we need to find coordinates for the next cell 
//                 int coordinate[] = getCoordinate(nextCell , n);

//                 int r = coordinate[0];
//                 int c = coordinate[1];

//                 // using snake and ladder once 
//                 if(board[r][c] != -1){  // if there was any snake or ladder then nextCell will be the next position
//                     nextCell = board[r][c];
//                 }
//                 // and if the nextCell is already been visited then we can skip it 
//                 if(visited[nextCell]) continue;

//                 // otherwise we will visit this cell and add it to queue for further processing
//                 visited[nextCell] = true;
//                 q.offer(new int[]{nextCell , moves + 1});
//             }
//         }
//         return -1;       
//     }
// }

// Approach 2
class Solution {
    int n;

    // Converts cell number to board coordinates considering the zigzag pattern
    private int[] getCoord(int s) {
        int row = n - 1 - (s - 1) / n;
        int col = (s - 1) % n;
        
        if ((n % 2 == 1 && row % 2 == 1) || (n % 2 == 0 && row % 2 == 0)) {
            col = n - 1 - col;
        }
        
        return new int[]{row, col};
    }

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1); // Start from cell 1
        visited[n - 1][0] = true;
        
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == n * n) return steps;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    int[] coord = getCoord(next);
                    int r = coord[0], c = coord[1];
                    
                    if (visited[r][c]) continue;

                    visited[r][c] = true;

                    if (board[r][c] == -1) {
                        queue.offer(next);
                    } else {
                        queue.offer(board[r][c]);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
