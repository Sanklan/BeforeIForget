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
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         Stack<TreeNode> pStack = new Stack<TreeNode>();
         Stack<TreeNode> qStack = new Stack<TreeNode>();
        
        findPath(root, p, pStack);
        findPath(root, q, qStack);
        while(pStack.size() != qStack.size()) {
            if(pStack.size() > qStack.size()) {
                pStack.pop();
            }
            if(pStack.size() < qStack.size()) {
                qStack.pop();
            }
        }
        while(!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode a = pStack.pop();
            TreeNode b = qStack.pop();
            if(a.val == b.val) {
                return a;
            }
        }
        
        return new TreeNode(-1);
        
    }
    
    public boolean findPath(TreeNode start, TreeNode search, Stack<TreeNode> path) {
        if(start == null)
            return false;
        path.push(start);
        if(start.val == search.val) return true;
        
        boolean found = findPath(start.left, search, path);
        if(!found) {
            found = findPath(start.right, search, path);
        } else {
            return true;
        }
        
        if(!found) {
            path.pop();
            return false;
        } else {
            return true;
        }
        
        
    }
}