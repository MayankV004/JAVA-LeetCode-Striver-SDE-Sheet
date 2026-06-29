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
    public TreeNode constructTree(int preorder[] , int start , int end , Map<Integer, Integer> map ){
        // Base case
        if(start > end){
            return null;
        }
        int rootVal = preorder[idx++];
        int mid = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = constructTree(preorder , start , mid-1  , map);
        root.right = constructTree(preorder , mid + 1 , end , map);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int []inorder = Arrays.copyOf(preorder , n);
        Arrays.sort(inorder);
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(inorder[i] , i);
        }
        return constructTree(preorder , 0 , n-1 , map);   
    }
}