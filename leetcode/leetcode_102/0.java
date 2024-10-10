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
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int size;
        List<Integer> temp;
        TreeNode current;
        while(!q.isEmpty()) {
            temp = new ArrayList<Integer>();
            size = q.size();
            while(size > 0) {
                current = q.poll();
                temp.add(current.val);
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
                size--;
            }

            res.add(temp);
        }

        return res;
    }
}