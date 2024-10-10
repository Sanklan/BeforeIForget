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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        double avg;
        int count, i;
        TreeNode node;
        queue.offer(root);
        while(!queue.isEmpty()) {
            count = queue.size();
            avg = 0.0;
            for(i = count; i > 0; i--) {
                node = queue.poll();
                avg += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(avg/count);
        }
        return ans;
    }
}