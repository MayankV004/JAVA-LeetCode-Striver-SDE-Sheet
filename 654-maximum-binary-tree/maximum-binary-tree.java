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
    public TreeNode constructTree(int []nums , int start , int end ){
        if(start > end){
            return null;
        }
        int maxElementIdx = start;
        for(int i = start ; i <= end ; i++){
            if(nums[i] > nums[maxElementIdx]){maxElementIdx = i;}
        }
        
        int maxElement= nums[maxElementIdx];

        TreeNode root = new TreeNode(maxElement);
        root.left = constructTree(nums , start , maxElementIdx-1 );
        root.right = constructTree(nums , maxElementIdx + 1 , end);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;  
        return constructTree(nums , 0 , n-1);
    }
}