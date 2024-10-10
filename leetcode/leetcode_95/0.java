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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> roots = new ArrayList<TreeNode>();
        memo = new HashMap<String, List<TreeNode>>();
        return trees(1, n);

    }

    HashMap<String, List<TreeNode>> memo;
    private static String key(int start, int end) {
        return start + "_" + end;
    }
    private List<TreeNode> trees(int start, int end) {
        if (start > end) return null;
        if (memo.containsKey(key(start, end))) 
            return memo.get(key(start, end));
        
        List<TreeNode> roots = new ArrayList<TreeNode>();
        if (start == end) {
            roots.add(new TreeNode(start));
        } else {
            for(int current = start; current <= end; current++) {
                List<TreeNode> lefts = trees(start, current - 1);
                List<TreeNode> rights = trees(current + 1, end);
                if (lefts == null)
                for(TreeNode right:rights)
                        roots.add(new TreeNode(current, null, right));
                else if (rights == null)
                    for(TreeNode left:lefts)
                        roots.add(new TreeNode(current, left, null));
                else for(TreeNode left:lefts)
                        for(TreeNode right:rights)
                            roots.add(new TreeNode(current, left, right));
            }
        }
        memo.put(key(start, end), roots);
        return roots;
    }
}