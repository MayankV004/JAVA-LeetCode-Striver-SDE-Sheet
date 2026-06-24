/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Tuple{
        TreeNode node;
        int level;
        int col;

        public Tuple(TreeNode node , int level , int col ){
            this.node = node;
            this.level  = level;
            this.col  = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();
             // <Vertical Column number , Sorted<Level , minHeap[list of nodes at that level]>>
        Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(root , 0 , 0));

        while(!q.isEmpty()){
            Tuple current = q.poll();

            TreeNode node = current.node;
            int level = current.level;
            int column = current.col;

            map.putIfAbsent(column , new TreeMap<>());
            map.get(column).putIfAbsent(level , new PriorityQueue<>());

            map.get(column).get(level).offer(node.val);

            if(node.left != null) q.offer(new Tuple(node.left , level + 1, column - 1 ));
            if(node.right != null ) q.offer(new Tuple(node.right , level+1 , column + 1));
        }

        List<List<Integer>> res = new ArrayList<>();

        for(TreeMap<Integer , PriorityQueue<Integer>> it : map.values()){
            List<Integer> verticalNodes = new ArrayList<>();
            for(PriorityQueue<Integer> pq : it.values()){
                while(!pq.isEmpty()){
                    verticalNodes.add(pq.poll());
                }
            }
            res.add(verticalNodes);
        }

        return res;
    }
}