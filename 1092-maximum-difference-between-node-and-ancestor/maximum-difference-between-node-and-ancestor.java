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
    public int allPaths(TreeNode root , int currentMax , int currentMin){
        if (root == null) return currentMax - currentMin;

        currentMax = Math.max(currentMax , root.val);
        currentMin = Math.min(currentMin , root.val);

        int left = allPaths(root.left , currentMax , currentMin);
        int right = allPaths(root.right , currentMax , currentMin);

        return Math.max(left ,right);
    }
    public int maxAncestorDiff(TreeNode root) {
        // Ultimately we need to find the differnce B/W two nodes such that the difference B/W the values is Maximum
        // and they are on same path from root 

        return allPaths(root , root.val , root.val);
    }
}