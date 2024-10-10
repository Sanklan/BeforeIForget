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
    public boolean isBalanced(TreeNode root) {
        //System.out.println(isBalancedHeightCheck(root));
        return isBalancedHeightCheck(root) != Integer.MIN_VALUE;
    }

    private int isBalancedHeightCheck(TreeNode node) {
        if (node == null) return 0;
        int left = isBalancedHeightCheck(node.left);
        //System.out.println("left " + left);
        if (left == Integer.MIN_VALUE) 
            return left;
        int right = isBalancedHeightCheck(node.right);
        
        //System.out.println("right " + right);
        if (right == Integer.MIN_VALUE) 
            return right;

        if (Math.abs(left - right) > 1) return Integer.MIN_VALUE;
        return Math.max(left, right) + 1;
    }
}