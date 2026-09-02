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
    HashMap<TreeNode, Integer> mapping = new HashMap();
   private int compute(TreeNode node) {
        if(node == null) { 
            return 0;
        }
        if(node.left == null && node.right == null) {
            return node.val;
        }
        if(mapping.containsKey(node)) {
            return mapping.get(node);
        }
        int notTaking = compute(node.left)+compute(node.right);
        int taking = node.val;
        if(node.left != null) {
            taking += compute(node.left.left) + compute(node.left.right);
        }
        if(node.right != null) {
            taking += compute(node.right.left) + compute(node.right.right);
        }
        mapping.put(node, Math.max(taking, notTaking));
        return mapping.get(node);
    }
    public int rob(TreeNode root) {
        return compute(root);
    }
}