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
    public int maxAncestorDiff(TreeNode root) {
        explore(root);
        return max;
    }

    // 0 min; 1 max
    private int[] explore(TreeNode node) {
       int cur_min = node.val;
       int cur_max = node.val;
       if (node.left != null) {
           int[] vals = explore(node.left);
           cur_min = Math.min(cur_min, vals[0]);
           cur_max = Math.max(cur_max, vals[1]);
       }
       if (node.right != null) {
           int[] vals = explore(node.right);
           cur_min = Math.min(cur_min, vals[0]);
           cur_max = Math.max(cur_max, vals[1]);
       }

       max = Math.max(max, Math.abs(node.val - cur_max));
       max = Math.max(max, Math.abs(node.val - cur_min));

       return new int[] {cur_min, cur_max};

    }

    private int max = 0;
}