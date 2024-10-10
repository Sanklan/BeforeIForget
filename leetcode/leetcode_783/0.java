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
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }

    private TreeNode search(TreeNode current, int val) {
        if (current == null) return null;
        else if (current.val == val) return current;
        else if (current.val > val) return search(current.left, val);
        else return search(current.right, val);
    }
}