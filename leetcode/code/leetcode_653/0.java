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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        explore(root, sorted);
        int i = 0;
        int j = sorted.size() - 1;
        int sum;
        while(i < j) {
            sum = sorted.get(i) + sorted.get(j);
            if (sum == k) return true;
            else if (sum < k ) i++;
            else j--;
        }

        return false;
    }

    private void explore(TreeNode root, ArrayList<Integer> sorted) {
        if (root == null) return;
        if (root.left != null) {
            explore(root.left, sorted);
        }
        sorted.add(root.val);

        if (root.right != null) {
            explore(root.right, sorted);
        }
    }
}