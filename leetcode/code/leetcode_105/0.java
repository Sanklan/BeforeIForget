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
        preInd = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < preorder.length; i++) map.put(inorder[i], i);
        return build(preorder, inorder, 0, preorder.length -1, map);
    }
    int preInd;
    private TreeNode build(int[] preorder, int[] inorder, int x, int y, HashMap<Integer, Integer> map) {
        
        if (x > y || preInd == preorder.length) return null;

        TreeNode node = new TreeNode(preorder[preInd]);
        int mid = map.get(preorder[preInd]);
        preInd++;
        if (x < y) {
            node.left = build(preorder, inorder, x, mid - 1, map);
            node.right = build(preorder, inorder, mid + 1, y, map);
        }
        return node;
    }
}