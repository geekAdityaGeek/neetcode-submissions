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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<Integer> ans = new ArrayList();
        Queue<TreeNode> Q = new LinkedList();
        Q.add(root);
        while (!Q.isEmpty()) {
            int len = Q.size();
            while (len > 0) {
                TreeNode node = Q.remove();
                if (len == 1) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
                len--;
            }
        }
        return ans;
    }
}
