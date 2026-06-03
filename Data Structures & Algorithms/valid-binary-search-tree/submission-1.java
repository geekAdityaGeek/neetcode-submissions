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
    List<Integer> data = new ArrayList();
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        data.add(node.val);
        traverse(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        traverse(root);
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) <= data.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
