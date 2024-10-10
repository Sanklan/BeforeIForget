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
        final HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        dfs(root, 1, count);
        int max = count.keySet().stream()
        .max((key1, key2) -> count.get(key1).compareTo(count.get(key2)))
        .get();
        return max;
    }

    private void dfs(TreeNode current, int level, HashMap<Integer, Integer> map) {
        if (current != null) {
            map.put(level, map.getOrDefault(level, 0) + current.val);
            dfs(current.left, level + 1, map);
            dfs(current.right, level + 1, map);
        }
    }
}