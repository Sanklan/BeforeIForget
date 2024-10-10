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
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidNode(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val < min || node.val > max) return false;
        if (node.val == Integer.MIN_VALUE && node.left != null) return false;
        if (node.val == Integer.MAX_VALUE && node.right != null) return false;
        return isValidNode(node.left, min, node.val - 1) && isValidNode(node.right, node.val + 1, max);
    }
}