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
    int backSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        // doing reverse Inorder traversal to get the sum from right
        convertBST(root.right);
        backSum += root.val;
        root.val = backSum;
        convertBST(root.left);

        return root;
    }
}