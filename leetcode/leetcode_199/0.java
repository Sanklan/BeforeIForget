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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode current;
        int count, size = 1;
        while(!queue.isEmpty()) {
            count = size;
            size = 0;
            list.add(queue.peek().val);
            while(count > 0) {
                current = queue.poll();
                if (current.right != null) {
                    queue.add(current.right);
                    size++;
                }
                if (current.left != null) {
                    queue.add(current.left);
                    size++;
                }
                count--;
            }
        }

        return list;
    }

    // private void dfs(TreeNode current, List<Integer> list) {
    //     if (current == null) return;
    //     list.add(current.val);
    //     if (current.right != null) dfs(current.right, list);
    //     else if (current.left != null) dfs(current.left, list);
    // }
}