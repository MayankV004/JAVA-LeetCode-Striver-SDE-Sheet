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
    List<String> ans = new ArrayList<>();

    public void allPaths(TreeNode root, String path) {
        if (root == null)
            return;

        if(path.isEmpty()){
            path += root.val;
        }else{
            path += "->"+root.val;
        }

        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        allPaths(root.left , path);
        allPaths(root.right , path);
        
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ans;
        allPaths(root, "");
        return ans;
    }
}