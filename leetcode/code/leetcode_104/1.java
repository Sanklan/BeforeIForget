/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return findDepth(root);
    }
    
    private int findDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int depth = 1;
        int left = findDepth(node.left);
        int right = findDepth(node.right);
        return (left > right) ? depth + left : depth + right; 
    }
}