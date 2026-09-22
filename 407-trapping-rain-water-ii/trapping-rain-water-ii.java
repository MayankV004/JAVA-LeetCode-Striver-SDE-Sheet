class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[][] visited = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            pq.offer(new int[]{ heightMap[row][0], row, 0 });
            visited[row][0] = true;

            pq.offer(new int[]{ heightMap[row][n - 1], row, n - 1 });
            visited[row][n - 1] = true;
        }

        for (int col = 0; col < n; col++) {
            pq.offer(new int[] { heightMap[0][col], 0, col });
            visited[0][col] = true;

            pq.offer(new int[] { heightMap[m - 1][col], m - 1, col });
            visited[m - 1][col] = true;
        }

        int water = 0;
        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int height = curr[0];
            int i = curr[1];
            int j = curr[2];

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && nj >= 0 && ni < m && nj < n && !visited[ni][nj]) {
                    water += Math.max(height - heightMap[ni][nj], 0);
                    pq.offer(new int[] { Math.max(height, heightMap[ni][nj]), ni, nj });
                    visited[ni][nj] = true;
                }
            }

        }
        return water;
    }
}
