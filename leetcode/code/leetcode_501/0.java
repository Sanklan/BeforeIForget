import java.util.Map;
import java.util.HashMap; 
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
    
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        traverse(root, frequency);
        
        int maxFreq = 0;
        for(int val:frequency.values()) {
            if(maxFreq < val) {
                maxFreq = val;
            }
        }
        
        List<Integer> al = new ArrayList<Integer>();
        for(int key:frequency.keySet()){
            if(frequency.get(key) == maxFreq) {
                al.add(key);
            }
        }
        
        int [] ret = new int[al.size()];
        int i = 0;
        for(int val:al) {
            ret[i++] = val;
        }
        return ret;
        
    }
    
    private void traverse(TreeNode node, HashMap<Integer, Integer> frequency) {
        if(node == null) return;
        if(frequency.containsKey(node.val)) {
            int val = frequency.get(node.val);
            frequency.replace(node.val, val + 1);
            
        } else {
            frequency.put(node.val, 1);            
        }
           
        traverse(node.left, frequency);
        traverse(node.right, frequency);
    }
}