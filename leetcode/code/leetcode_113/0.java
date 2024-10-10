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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        recur(root, targetSum, new ArrayList<Integer>(), 0, result);
        return result;
    }

    private void recur(TreeNode root, int target, List<Integer> current, int sum, List<List<Integer>> result) {
        if (root == null) return;
        int len = current.size();
        current.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(current));
            }
        } else {
            if (root.left != null) recur(root.left, target, current, sum, result);

            if (root.right != null) recur(root.right, target, current, sum, result);
        }
        current.remove(len);
    }
}