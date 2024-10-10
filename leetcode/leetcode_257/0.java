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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        dfs(root, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(TreeNode current, StringBuilder str, List<String> ans) {
        if (current == null) return;
        int len = str.length();
        str.append(current.val);
        if (current.left == null && current.right == null) {
            ans.add(str.toString());
            str.deleteCharAt(str.length() - 1);
        }
        else { 
            str.append("->");
            if (current.left != null) {
                dfs(current.left, str, ans);
            }
            if (current.right != null) {
                dfs(current.right, str, ans);
            }
        }

        str.setLength(len);

    }
}