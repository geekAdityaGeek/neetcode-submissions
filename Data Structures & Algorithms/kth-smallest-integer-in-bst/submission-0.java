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
    int cnt = 0;
    TreeNode data = null;
    private void traverse(TreeNode node) {
        if(node == null || cnt == 0) {
            return;
        }
        traverse(node.left);
        if(cnt == 1) {
            data = node;
        }
        cnt--;
        traverse(node.right);

    }
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        traverse(root);
        return data.val;
    }
}
