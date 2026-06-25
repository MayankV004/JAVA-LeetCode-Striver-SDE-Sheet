/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void inOrder(TreeNode root ,  Map<TreeNode , TreeNode> parent){
        if(root == null) return ;

        if(root.left != null){
            parent.putIfAbsent(root.left , root);
            inOrder(root.left , parent);
        }
        if(root.right != null){
            parent.putIfAbsent(root.right , root);
            inOrder(root.right , parent);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();

        Map<TreeNode , TreeNode> parent = new HashMap<>();
        inOrder(root , parent);

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(target);

        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);

        while(!q.isEmpty()){
            int size = q.size();

            if(k == 0){
                break;
            }

            while(size-- > 0){
                TreeNode node = q.poll();

                //left
                if(node.left != null && !visited.contains(node.left.val)){
                    visited.add(node.left.val);
                    q.offer(node.left);
                }

                // right
                if(node.right != null && !visited.contains(node.right.val)){
                    visited.add(node.right.val);
                    q.offer(node.right);
                }

                // Parent
                if(parent.containsKey(node) && !visited.contains(parent.get(node).val)){
                    visited.add(parent.get(node).val);
                    q.offer(parent.get(node));
                }
            }
            k--;
        }

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            res.add(node.val);
        }

        return res;
    }
}