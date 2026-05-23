/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node , Node> map = new HashMap<>();

    public void dfs(Node node , Node cloneNode){

        for(Node neighbor : node.neighbors){

            // If neighbor is not cloned yet
            if(!map.containsKey(neighbor)){

                // Create clone of neighbor
                Node clone = new Node(neighbor.val);

                // Store mapping
                map.put(neighbor , clone);

                // Connect current cloned node with cloned neighbor
                cloneNode.neighbors.add(clone);

                // DFS on neighbor
                dfs(neighbor , clone);

            }else{

                // Neighbor already cloned
                // Just connect it
                cloneNode.neighbors.add(map.get(neighbor));
            }
        }
    }

    public Node cloneGraph(Node node) {

        if(node == null) return null;
        Node cloneNode = new Node(node.val);
        map.put(node , cloneNode);
        dfs(node , cloneNode);
        return cloneNode;
    }
}


/*
-------------------------------- EXPLANATION --------------------------------

Goal:
We need to create a deep copy of the graph.

Deep Copy means:
1. Create completely new nodes
2. Preserve all connections
3. No node from original graph should be reused


Why HashMap is needed?

Graphs can contain:
1. Cycles
2. Multiple paths to same node

Without HashMap:
- Same node may get cloned multiple times
- Infinite recursion can happen

So we store:

original node -> cloned node

Example:
1 -> clone(1)
2 -> clone(2)


How DFS Works:

Suppose graph is:

1 -- 2
|    |
4 -- 3

Step 1:
Clone node 1
Store:
map.put(1, clone1)

Step 2:
Visit neighbors of 1

Neighbor = 2
Not cloned yet:
- Create clone2
- Connect clone1 -> clone2
- DFS on 2

Step 3:
Eventually DFS again reaches node 1

Now:
map.containsKey(1) == true

So instead of creating another clone,
we simply use the existing cloned node.


Main Logic:

For every neighbor:
1. If not cloned:
   - create clone
   - store in map
   - connect nodes
   - DFS further

2. Else:
   - directly connect existing clone


Time Complexity:
O(V + E)

V = number of vertices
E = number of edges

Each node and edge is visited once.


Space Complexity:
O(V)

Used by:
1. HashMap
2. Recursion stack
*/