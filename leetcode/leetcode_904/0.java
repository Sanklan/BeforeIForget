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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafsOne = new ArrayList<Integer>();
        List<Integer> leafsTwo = new ArrayList<Integer>();
        dfs(root1, leafsOne);
        dfs(root2, leafsTwo);
        
        if (leafsOne.size() != leafsTwo.size()) return false;
        int n = leafsOne.size();
        for(int i = 0; i < n; i++)
            if (!leafsOne.get(i).equals(leafsTwo.get(i))) return false;
        return true;
    }

    private void dfs(TreeNode current, List<Integer> leafs) {
        if (current == null) return;
        else if (current.left == null && current.right == null) 
            leafs.add(current.val);
        else {
            dfs(current.left, leafs);
            dfs(current.right, leafs);
        }
    }
}