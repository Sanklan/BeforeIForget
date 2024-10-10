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
        ArrayList<Integer> result = inorderTraversal(root, new ArrayList<Integer>());
       // System.out.println(Arrays.toString(result.toArray()));
        return result.get(k - 1);
    }
    
    private ArrayList<Integer> inorderTraversal(TreeNode root, ArrayList<Integer> result) {             
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);       
            inorderTraversal(root.right, result);
        }       
        return result;
    }

}