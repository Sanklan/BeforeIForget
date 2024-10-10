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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0; 
        quickFind.clear();
        for(int i = 0; i < inorder.length; i++) quickFind.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, inorder.length - 1);
            
    }
    
    // take a index as current node and find it's children
    public TreeNode buildTree(int[] preorder, int[] inorder, int inorderStart, int inorderEnd) {
            TreeNode root = new TreeNode(preorder[preOrderIndex]);
            int nodeIndex = quickFind.get(preorder[preOrderIndex]);
            preOrderIndex++;
            if (nodeIndex > inorderStart) {
                root.left = buildTree(preorder, inorder, inorderStart, nodeIndex - 1);
            }
            if (nodeIndex < inorderEnd) {
                root.right = buildTree(preorder, inorder, nodeIndex + 1, inorderEnd);
            }

            return root;
    }

    HashMap<Integer, Integer> quickFind = new HashMap<Integer, Integer>();
    private int preOrderIndex;
}