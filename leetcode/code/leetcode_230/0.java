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
    public int kthSmallest(TreeNode root, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        recur(root, k, map);
        //map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        return map.get(1);
    }

    private int recur(TreeNode root, int k, HashMap<Integer, Integer> group) {
        if (root == null || k <= 0) {
            return -1;
        }
        if (root.left != null) {
            k = recur(root.left, k, group);
        }
        group.put(k, root.val);
        k-=1;
        
        if (root.right != null) {
            k = recur(root.right, k, group);
        }

        return k;

    }

}