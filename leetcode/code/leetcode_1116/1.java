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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int max = root.val;
        int level  = 1;
        int maxLevel = 1;
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        current.add(root);

        int size = 0;
        int sum = 0;
        while(!current.isEmpty()) {
            size = current.size();
            sum = 0;
            while(size > 0) {
                TreeNode node = current.poll();
                sum += node.val;
                if (node.left != null) {
                    current.add(node.left);
                }

                if (node.right != null) {
                    current.add(node.right);
                }

                size--;
            }

            if (max < sum) {
                max = sum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;

    }
}