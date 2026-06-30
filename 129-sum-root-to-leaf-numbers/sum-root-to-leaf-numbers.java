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
//Approach 1
// class Solution {
//     public void allPaths(TreeNode root , String path , List<String> res){
//         if(root == null) return ;

//         path += root.val;

//         if(root.left == null && root.right == null){
//             res.add(path);
//         }

//         allPaths(root.left , path , res);
//         allPaths(root.right , path , res);
//     }
//     public int sumNumbers(TreeNode root) {
//         List<String> res = new ArrayList<>();
//         allPaths(root , "" , res);

//         int ans = 0 ;

//         for(String s : res){
//             ans += Integer.valueOf(s);
//         }

//         return ans;

//     }
// }

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int current){
        if(root == null){
            return 0;
        }

        current = current * 10 + root.val;

        if(root.left == null && root.right == null){
            return current;
        }

        return dfs(root.left, current) + dfs(root.right , current);
    }
}