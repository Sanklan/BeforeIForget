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
    public void flatten(TreeNode root) {
        flattenAndGetTail(root);
    }

    private TreeNode flattenAndGetTail(TreeNode current) {
        if (current == null) return null;
        TreeNode tail = current;
        if (current.left != null) 
        {
            tail = flattenAndGetTail(current.left);
            tail.right = current.right;
            current.right = current.left;
            current.left = null;
        }
        if (tail.right != null) tail = flattenAndGetTail(tail.right);

        return tail;
    }
}