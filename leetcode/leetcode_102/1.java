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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        while(!stack.isEmpty()) {
            List<Integer> r = new ArrayList<Integer>();
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                r.add(node.val);
                if (node.left != null) nextLevel.push(node.left);
                if (node.right != null) nextLevel.push(node.right);
            }

            while(!nextLevel.isEmpty()) stack.push(nextLevel.pop());
            res.add(r);
        }

        return res;
    }
}