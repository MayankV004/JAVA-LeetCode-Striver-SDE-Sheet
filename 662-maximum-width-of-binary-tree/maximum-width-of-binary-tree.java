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
    class Pair{
        TreeNode node ;
        long idx ; 
        public Pair(TreeNode node , long idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        Deque<Pair> dq = new ArrayDeque<>();
        dq.offerLast(new Pair(root , 0L));

        int maxWidth = Integer.MIN_VALUE;

        while(!dq.isEmpty()){
            int size = dq.size();

            long left = dq.peekFirst().idx;
            long right = dq.peekLast().idx;

            maxWidth = Math.max(maxWidth , (int)(right - left + 1 ));

            while(size-- > 0){
                TreeNode node = dq.peekFirst().node;
                long idx = dq.peekFirst().idx;
                dq.poll();
                if(node.left != null ) dq.offerLast(new Pair(node.left , 2 * idx + 1 ) );
                if(node.right != null ) dq.offerLast(new Pair(node.right , 2 * idx + 2 ) );
            }

        }
        return maxWidth;
    }
}