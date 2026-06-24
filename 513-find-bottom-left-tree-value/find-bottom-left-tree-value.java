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
    public void preOrder(TreeNode root , int level , List<Integer> res){
        if(root == null) return ;

        if(level == res.size()){
            res.add(root.val);
        }

        preOrder(root.left , level + 1 , res);
        preOrder(root.right , level + 1 , res);

    }
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root , 0 , res);

        return res.get(res.size()-1);
    }
}