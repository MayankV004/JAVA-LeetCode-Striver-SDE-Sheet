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
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<TreeNode> deepest = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            deepest = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = q.poll();
                deepest.add(node);

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }
        }

        // Compute LCA of all deepest leaves
        TreeNode ans = deepest.get(0);

        for (int i = 1; i < deepest.size(); i++) {
            ans = lca(root, ans, deepest.get(i));
        }

        return ans;
    }
}