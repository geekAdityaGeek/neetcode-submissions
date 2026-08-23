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
    private void nodeToBeInserted (int val, TreeNode node) {
        if(val < node.val) {
            if(node.left == null) {
                node.left = new TreeNode(val);
            } else {
                nodeToBeInserted(val, node.left);
            }
        } else if(val > node.val) {
            if(node.right == null) {
                node.right = new TreeNode(val);

            } else {
                nodeToBeInserted(val, node.right);
            }
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        nodeToBeInserted(val, root);
        return root;
    }
}