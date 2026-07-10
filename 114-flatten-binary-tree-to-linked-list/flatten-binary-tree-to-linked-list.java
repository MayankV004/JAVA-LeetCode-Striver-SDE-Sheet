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
    List<Integer> preorder = new ArrayList<>();
    public void preorderTraversal(TreeNode root){
        if(root == null) return;

        preorder.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    public void flatten(TreeNode root) {
        if(root == null ) return ;
        preorderTraversal(root);
        TreeNode head = root;
        for(int i = 1 ; i < preorder.size() ; i++ ){
            head.left = null;
            head.right = new TreeNode(preorder.get(i));
            head = head.right;
        }
        head.left = null;
        head.right = null;
    }
}