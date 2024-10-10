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
    public int maxPathSum(TreeNode root) {
        //max = ;
        MaxRes mr = new MaxRes();
        mr.max = Integer.MIN_VALUE;
        maxPathSum1(root, mr);
        return mr.max;
    }
    //private Integer max;
    
    class MaxRes {
        int max;
    }
    
    private int maxPathSum1(TreeNode root, MaxRes mr) {
        //if (root == null) return 0;
        //if (root.left == null && root.right == null) return root.val;
        int left = (root.left != null) ? maxPathSum1(root.left, mr) : Integer.MIN_VALUE;
        int right = (root.right != null) ?  maxPathSum1(root.right, mr) : Integer.MIN_VALUE;
        
        int tempMax = root.val;
        if (root.left != null) tempMax = Math.max(tempMax, root.val + left);
        if (root.right != null) tempMax = Math.max(tempMax, root.val + right);
        int retVal = tempMax;
        if (root.left != null && root.right != null)
            tempMax = Math.max(tempMax , left + right + root.val);
        
        mr.max = Math.max(mr.max, tempMax);
        //System.out.println(root.val + " : " + mr.max);
        return retVal;
    }
}