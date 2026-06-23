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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null ) return null;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            List<TreeNode> levelNodes = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();

                levelNodes.add(node);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            if(level % 2 != 0){
                int left = 0; int right = levelNodes.size()-1;

                while(left < right){
                    int temp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = temp;
                    left++;right--;
                }
            }
            level++;
        }
        return root;
    }
}