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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, 0, targetSum);
    }

    private boolean leaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private boolean dfs(TreeNode node, int sum, int targetSum) {
        sum += node.val;
        if (leaf(node)) return sum == targetSum;
        
        if (node.left != null && dfs(node.left, sum, targetSum)) return true;
        if (node.right != null && dfs(node.right, sum, targetSum)) return true;

        return false;
    }
}