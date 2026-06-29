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
    public int heightOfTree(TreeNode root){
        if(root == null) return 0;

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        return 1 + Math.max(left , right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        int depth = Math.abs(left - right);

        if(depth > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}