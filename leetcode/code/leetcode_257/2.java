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
        List<String> ret = new ArrayList<String>();
        binaryTreePaths(root, "", ret);
        return ret;
    }

    private void binaryTreePaths(TreeNode current, String s, List<String> ret) {
        if ( current != null) {
          if (s.length() == 0) s = String.valueOf(current.val);
          else s = s + "->" + current.val;

        if (current.left == null && current.right == null) 
        {
                ret.add(s);
                return;
        }
        if (current.left != null) binaryTreePaths(current.left, s, ret);
        if (current.right != null) binaryTreePaths(current.right, s, ret);
        }
    }
}