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

 // Approach 1 - > Using Bitmask eleminating the extra space used by the array
class Solution {
    public int allPaths(TreeNode root , int mask ){
        if(root == null) return 0;
        
        // same values will cancel the set bis and if the at last only oneBit is set or no Bit is set then thats +1 to the ans
        mask = mask ^ (1 << root.val);

        if(root.left == null && root.right == null){
            int pathAns = (mask == 0 || (mask & (mask-1)) == 0) ? 1 : 0; // these conditon checks whether there is not set bit or 1 set bit
            return pathAns;
        }
        return allPaths(root.left , mask) + allPaths(root.right , mask);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        
        return allPaths(root , 0);    
    }
}

// Approach 2 - (using a Array of len 10 and checking whether the oddFreq is <=1 or not for result)
// class Solution {
//     int res = 0;
//     public void allPaths(TreeNode root , int []count ){
//         if(root == null) return ;

//         count[root.val]++;

//         if(root.left == null && root.right == null){
//             int oddFreq = 0;
//             for(int i = 0 ; i < 10 ; i++){
//                 if(count[i] % 2 != 0){
//                     oddFreq++;
//                 }
//             }

//             if(oddFreq <= 1){
//                 res++;
//             }
//         }

//         allPaths(root.left , count);
//         allPaths(root.right , count);

//         count[root.val]--; // backtracking
//     }
//     public int pseudoPalindromicPaths (TreeNode root) {
//         int []count = new int[10];

//         allPaths(root , count);

//         return res;
//     }
// }