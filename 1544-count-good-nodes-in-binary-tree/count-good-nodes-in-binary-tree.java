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
    int goodNodes = 0;
    public void preorder(TreeNode root , int pathMaxNode ){
        if(root == null ) return ;
        pathMaxNode = Math.max(pathMaxNode , root.val);
        if(root.val >= pathMaxNode){
            goodNodes++;
        }

        preorder(root.left , pathMaxNode);
        preorder(root.right , pathMaxNode);
    }
    public int goodNodes(TreeNode root) {
        preorder(root , root.val);
        return goodNodes;
    }
}