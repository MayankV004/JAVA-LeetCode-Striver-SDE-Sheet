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
    int idx = 0;
    public TreeNode constructTree(int[] postorder , int start , int end ,  Map<Integer , Integer> map ){
        if(start > end) return null;

        int rootValue = postorder[idx--];

        int mid = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);

        root.right = constructTree(postorder , mid + 1 , end , map);
        root.left = constructTree(postorder , start , mid - 1 , map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(inorder[i] , i);
        }
         
        idx = n-1;

        return constructTree(postorder , 0 , n-1 , map);
    }
}