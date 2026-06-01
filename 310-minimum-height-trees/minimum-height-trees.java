class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();

        // Edge case: no nodes
        if (n == 0) {
            return res;
        }

        // Edge case: single node tree
        if (n == 1) {
            res.add(0);
            return res;
        }

        int degree[] = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph + calculate degree of every node
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        // Add all current leaf nodes
        // Leaf node => degree == 1
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        // Keep removing leaves layer by layer
        while (n > 2) {

            int qSize = q.size();

            // Removing current leaves
            n -= qSize;

            while (qSize-- > 0) {

                int node = q.poll();

                // Visit neighbors
                for (int neighbor : graph.get(node)) {

                    // Remove edge between node and neighbor
                    degree[neighbor]--;

                    // If neighbor becomes leaf, add into queue
                    if (degree[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        // Remaining 1 or 2 nodes are answer
        res.addAll(q);

        return res;
    }
}

/*

===================== FULL EXPLANATION =====================

PROBLEM:
We need to find all roots of Minimum Height Trees (MHT).

Height of tree:
Maximum distance from root to any node.

Goal:
Choose node(s) as root such that height becomes minimum.

------------------------------------------------------------

IMPORTANT OBSERVATION:

The best roots are always the CENTER of the tree.

Why?

If we start removing leaf nodes layer by layer,
eventually only the center node(s) remain.

Those center nodes produce minimum height.

------------------------------------------------------------

EXAMPLE:

Tree:

      0
      |
      1
     / \
    2   3
         \
          4

Leaf nodes:
0,2,4

Remove them:

      1
       \
        3

Now both 1 and 3 are centers.

Answer = [1,3]

------------------------------------------------------------

APPROACH USED:
Topological BFS / Leaf Trimming

Steps:

1. Build graph using adjacency list.

2. Store degree of every node.
   Degree = number of connected neighbors.

3. Push all leaf nodes into queue.
   Leaf node => degree == 1

4. Remove leaves level by level:
   - Pop all current leaves
   - Reduce degree of neighbors
   - If neighbor becomes leaf, push into queue

5. Continue until only 1 or 2 nodes remain.

Those remaining nodes are MHT roots.

------------------------------------------------------------

WHY ONLY 1 OR 2 NODES REMAIN?

A tree can have:
- one center
OR
- two centers

Examples:

Odd length chain:
0-1-2-3-4
Center = 2

Even length chain:
0-1-2-3
Centers = 1,2

------------------------------------------------------------

TIME COMPLEXITY:

Building graph = O(n)
BFS traversal  = O(n)

Overall:
O(n)

------------------------------------------------------------

SPACE COMPLEXITY:

Graph storage = O(n)
Queue         = O(n)

Overall:
O(n)

============================================================

*/