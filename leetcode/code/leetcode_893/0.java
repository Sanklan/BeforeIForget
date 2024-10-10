/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        find(root, target, stack);
        if (stack.isEmpty()) return new ArrayList<Integer>();

        TreeNode target_new = stack.pop();
        List<Integer> ans = new ArrayList<Integer>();
        ans.addAll(depthSearch(target_new, k));


        if (root.val == target.val) return ans;
        int len = 1;
        TreeNode prev = target, temp;
        while(!stack.isEmpty() && k- len > 0) {
            temp = stack.pop();
            if (prev == temp.left) {
                ans.addAll(depthSearch(temp.right, k - len - 1));
            } else if (prev == temp.right) {
                ans.addAll(depthSearch(temp.left, k - len - 1));
            }

            prev = temp;
            len++;
        }
        if (k - len == 0 && !stack.isEmpty()) ans.add(stack.pop().val);

        return ans;
    }

    //dfs to find value
    private boolean find(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null) return false;
        if (root.val == target.val) {
            stack.add(root);
            return true;
        }

        stack.add(root);

        if (root.left != null && find(root.left, target, stack)) return true;
        if (root.right != null && find(root.right, target, stack)) return true; 
        stack.pop();
        return false;
    }

    private List<Integer> depthSearch(TreeNode root, int depth) {
        if (depth < 0 || root == null) return new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int size = 0;
        TreeNode temp;
        queue.add(root);
        while(depth > 0 && !queue.isEmpty()) {
            size = queue.size();
            while(size > 0) {
                temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                size--;
            }
            depth--;
        }

        List<Integer> ret = new ArrayList<Integer>();
        while(!queue.isEmpty()) ret.add(queue.poll().val);

        return ret;
    }

}