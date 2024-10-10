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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        int currentLevel = 1;
        Stack<TreeNode> current = new Stack<TreeNode>();
        current.push(root);
        
        while(!current.empty()) {
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            List<Integer> resultLevel = new ArrayList<Integer>();
            
           //  System.out.println(current.size());
            
            while(!current.empty()) {                
                TreeNode temp = current.pop();
                if (temp == null) {
                    continue;
                }
                resultLevel.add(temp.val);
                if (currentLevel % 2 == 0) {
                    nextLevel.add(temp.right);
                    nextLevel.add(temp.left);
                } else {
                    nextLevel.add(temp.left);
                    nextLevel.add(temp.right);
                }
            }
            while(!nextLevel.isEmpty()) {
              current.push(nextLevel.remove());  
            }
            currentLevel += 1;
            if (resultLevel.size() > 0)
                result.add(resultLevel);
        }
        
        return result;
    }
}