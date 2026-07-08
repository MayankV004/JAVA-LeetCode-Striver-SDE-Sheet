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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        if(root.val >= low && root.val<= high){
            // got one value , therefore going in both left and right
            return root.val + rangeSumBST(root.left , low , high) + rangeSumBST(root.right, low , high);
        }

        // when value is less than low so no point in going left 
        if(root.val < low){
            return rangeSumBST(root.right , low , high);
        }

        // when value is higher than high so no point in going right 
        return rangeSumBST(root.left , low , high);
    }
}

//Approach 2
// class Solution {
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if (root == null)
//             return 0;
//         int sum = 0;
//         if (root.val >= low && root.val <= high)
//             sum += root.val;

//         if (root.val > low)
//             sum += rangeSumBST(root.left, low, high);
//         if (root.val < high)
//             sum += rangeSumBST(root.right, low, high);

//         return sum;
//     }
// }