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
    public int longestZigZag(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    private int[] dfs(TreeNode current) {
        if (current == null) return new int[] {-1, -1};
        int[] left = dfs(current.left);
        int[] right = dfs(current.right);
        int temp = Math.max(left[1], right[0]) + 1;
        max = Math.max(temp, max);
        return new int[] {1 + left[1], 1 + right[0]};
    }
    private int max;
}