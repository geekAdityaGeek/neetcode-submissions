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
    private TreeNode ans = null;
    private boolean traverse(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean currFound = false;
        if (node.val == p.val || node.val == q.val) {
            currFound = true;
        }
        boolean leftFound = traverse(node.left, p, q);
        boolean rightFound = traverse(node.right, p, q);
        // this means that LCA is already found
        if (ans != null) {
            return true;
        }
        if (currFound && (leftFound || rightFound)) {
            ans = node;
        } else if (leftFound && rightFound) {
            ans = node;
        }
        return currFound || leftFound || rightFound;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return ans;
    }
}
