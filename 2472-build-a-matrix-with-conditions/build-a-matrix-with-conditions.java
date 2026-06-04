class Solution {
    public int[] toposort(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int indegree[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            indegree[i] = 0;
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> toposortOrder = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            toposortOrder.add(node);

            for (int v : graph.get(node)) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        //cycle detected
        if(toposortOrder.size() != n) {
            return new int[]{};
        }

        int res[] = toposortOrder.stream().mapToInt(Integer::intValue).toArray();

        return res;
    }
    public int[][] getCoordinates(int[] row, int[] col) {
        int n = row.length;

        int[] rowPos = new int[n + 1];
        int[] colPos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            rowPos[row[i]] = i;
            colPos[col[i]] = i;
        }

        int[][] coordinates = new int[n + 1][2];

        for (int num = 1; num <= n; num++) {
            coordinates[num][0] = rowPos[num];
            coordinates[num][1] = colPos[num];
        }

        return coordinates;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        int rowToposort[] = toposort(k, rowConditions);
        int colToposort[] = toposort(k, colConditions);

        if (rowToposort.length != k ||  colToposort.length != k) {
            return new int[][] {}; // empty matrix
        }

        int [][]coordinates = getCoordinates(rowToposort , colToposort);

        int ans[][] = new int[k][k];

        for(int i = 1 ; i <= k ; i++ ){
            int r = coordinates[i][0];
            int c = coordinates[i][1];

            ans[r][c] = i;
        }

        return ans;

    }
}