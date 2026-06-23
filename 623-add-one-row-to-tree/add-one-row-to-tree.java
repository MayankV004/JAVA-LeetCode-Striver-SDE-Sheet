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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        int currentDepth = 2;
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();

                if(currentDepth == depth){
                    TreeNode leftTree = node.left;
                    TreeNode rightTree = node.right;

                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);

                    node.left.left = leftTree;
                    node.right.right= rightTree;    
                }else{
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);

                }

            }
            currentDepth++;
        }
        return root;
    }
}