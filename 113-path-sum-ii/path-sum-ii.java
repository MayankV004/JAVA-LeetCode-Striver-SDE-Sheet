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
    public void allPaths(TreeNode root , int targetSum , List<Integer> path , List<List<Integer>> res){
        if(root == null){
            return ;
        }

        path.add(root.val);

        if(root.left == null && root.right == null && targetSum == root.val){
            res.add(new ArrayList<>(path)); // adding the path to the result
        }else{
            allPaths(root.left , targetSum - root.val , path , res);
            allPaths(root.right , targetSum - root.val , path , res);
        }

        path.remove(path.size() - 1); // backtracking
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        allPaths(root , targetSum , new ArrayList<>() , res );
        return res;
    }
}