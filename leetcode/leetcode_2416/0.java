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
    public boolean evaluateTree(TreeNode root) {
        return evaluate(root);
    }
    
    private boolean evaluate(TreeNode current) {
        boolean isLeaf = (current.left == null && current.right == null);
        if (isLeaf) 
            return current.val == 1;
        
        boolean left = evaluate(current.left);
        boolean right = evaluate(current.right);
        
        if (current.val == 2) return left || right;
        else return left && right;
    }
}