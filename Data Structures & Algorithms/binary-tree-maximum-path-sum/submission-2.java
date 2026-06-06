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
    private int maxLen = Integer.MIN_VALUE;
    private int traverse(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftSum = traverse(node.left);
        int rightSum = traverse(node.right);
        int childMaxLen = Math.max(rightSum, leftSum);
        
        //different paths possible 
        // 1. start with current node and left subtree path
        // 2. start with current node and right subtree path
        // 3. left subtree node -> currNode -> right subtree node
        // 4. current node is the only path with max value
        maxLen = Math.max(maxLen, node.val+childMaxLen); // covers case #1, #2
        maxLen = Math.max(maxLen, node.val+leftSum+rightSum); // covers case #3
        maxLen = Math.max(maxLen, node.val); // covers case #4

        return Math.max(childMaxLen+node.val, node.val);
        
    }
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxLen;
    }
}
