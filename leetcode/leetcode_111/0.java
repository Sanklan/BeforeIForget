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
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.add(root);
        int depth = 0;
        if (root == null) return 0;
        int size;
        TreeNode node;
        while(!bfs.isEmpty()) {
            size = bfs.size();
            depth++;
            while(size > 0) {
                node = bfs.poll();
                if (leaf(node)) return depth;
                if (node.left != null) bfs.add(node.left);
                if (node.right != null) bfs.add(node.right);
                size--;
            }
        }

        return -1;
    }

    private boolean leaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}