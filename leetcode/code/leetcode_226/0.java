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
    public TreeNode invertTree(TreeNode root) {
        if(root != null)
            invertNode(root);
        return root;
    }
    
    private void invertNode(TreeNode node){
        if(node.right != null){
            invertNode(node.right);
        } 
        if(node.left != null) {
            invertNode(node.left);
        }
        if (node.right != null || node.left != null) {
            TreeNode tempNode = node.right;
            node.right = node.left;
            node.left = tempNode;
        }
        return;
    }
    
}