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
    public TreeNode allPaths(TreeNode root , int sum , int limit){
        if(root == null) return null;

        sum = sum + root.val;

        if(root.left == null && root.right==null){
            // leaf node
            if(sum < limit){
                return null;
            }
            return root;
        }

        root.left = allPaths(root.left , sum , limit);
        root.right = allPaths(root.right , sum , limit);

        if(root.left == null && root.right == null){
            return null;
        }

        return root;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return allPaths(root , 0 , limit);   
    }
}