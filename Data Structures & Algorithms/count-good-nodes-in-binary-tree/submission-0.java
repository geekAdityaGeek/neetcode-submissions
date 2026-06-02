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

    private int compute(TreeNode node, int max) {
        if(node == null) {
            return 0;
        }
        int cnt = 0;
        if(max == -200 || node.val >= max) {
            cnt++;
            max = node.val;
        }
        return cnt + compute(node.left, max) + compute(node.right, max);
    } 
    public int goodNodes(TreeNode root) {
        return compute(root, -200);
    }
}
