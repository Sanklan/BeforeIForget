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
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPSRecur(root);
        return max;
        
    }
    int max;
    private int maxPSRecur(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = maxPSRecur(root.left);
        int right = maxPSRecur(root.right);
        
        int maxL = root.val;
        
        if (left != Integer.MIN_VALUE) maxL = Math.max(maxL, left);
        if (right != Integer.MIN_VALUE) maxL = Math.max(maxL, right);
        if (left != Integer.MIN_VALUE) maxL = Math.max(maxL, left + root.val);
        if (right != Integer.MIN_VALUE) maxL = Math.max(maxL, right + root.val);

        if (left != Integer.MIN_VALUE &&  right != Integer.MIN_VALUE) maxL = Math.max(maxL, root.val + left + right);

        max = Math.max(max, maxL);

        int maxret = root.val;
        
        if (left != Integer.MIN_VALUE) maxret = Math.max(maxret, left + root.val);
        if (right != Integer.MIN_VALUE) maxret = Math.max(maxret, right + root.val);
        return maxret;

    }
}