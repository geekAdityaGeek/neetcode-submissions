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
    private TreeNode traverse(int[] preorder, int[] inorder, int posL, int posH, int l, int h) {
        if (posL >= preorder.length) {
            return null;
        }
        if (l == h) {
            System.out.println(l + ":" + h + " --> " + inorder[l]);
            return new TreeNode(inorder[l]);
        }
        int currElement = preorder[posL];
        int idx = l;
        while (idx <= h && inorder[idx] != currElement) {
            idx++;
        }
        int leftEnd = idx - 1;
        int rightStart = idx + 1;
        //System.out.println(
        //    l + ":" + h + " : " + posL + ":" + posH + " : " + leftEnd + ":" + rightStart);
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        if (leftEnd < l) {
            rightNode = traverse(preorder, inorder, posL + 1, posH, rightStart, h);
        } else if (rightStart > h) {
            leftNode = traverse(preorder, inorder, posL + 1, posH - 1, l, leftEnd);
        } else {
            leftNode = traverse(preorder, inorder, posL + 1, posL + (leftEnd - l + 1), l, leftEnd);
            rightNode =
                traverse(preorder, inorder, posL + (leftEnd - l + 1) + 1, posH, rightStart, h);
        }

        TreeNode currNode = new TreeNode(currElement);
        currNode.left = leftNode;
        currNode.right = rightNode;
        return currNode;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traverse(preorder, inorder, 0, preorder.length, 0, inorder.length - 1);
    }
}
