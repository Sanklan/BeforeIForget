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
        int count;
        while(!queue.isEmpty()) {
            count = queue.size();
            list.add(queue.peek().val);
            while(count > 0) {
                if (queue.peek().right != null) queue.add(queue.peek().right);
                if (queue.peek().left != null) queue.add(queue.peek().left);
                queue.poll();
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