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
    public TreeNode constructTree(int[]preorder , int start , int end ,  Map<Integer , Integer> map){
        if(start > end) return null;

        int rootValue = preorder[idx++];
        int mid = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        root.left = constructTree(preorder , start , mid - 1 , map);
        root.right = constructTree(preorder , mid+1 , end , map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++) map.put(inorder[i] , i);   
        
        return constructTree(preorder , 0 , preorder.length - 1 , map);
    }
}