import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        boolean leftToRight = true;

        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>();

            if (leftToRight) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = dq.pollFirst();
                    level.add(node.val);

                    if (node.left != null) {
                        dq.offerLast(node.left);
                    }
                    if (node.right != null) {
                        dq.offerLast(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = dq.pollLast();
                    level.add(node.val);

                    if (node.right != null) {
                        dq.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        dq.offerFirst(node.left);
                    }
                }
            }

            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;
    }
}