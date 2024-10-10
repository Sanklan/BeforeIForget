/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //import com.google.gson.Gson;
 //import org.json.simple.JSONObject;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "{}";
        return toString(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        return toNode(data, 0, data.length() - 1);
    }


    private String toString(TreeNode node)  {
         StringBuilder s = new StringBuilder();
         s.append("{");
         if (node != null) {
             s.append(node.val + "");
         }

         if (node.left != null) {
             s.append("{left=");
             s.append(toString(node.left));
             s.append("}");
         }

         if (node.right != null) {
             s.append("{right=");
             s.append(toString(node.right));
             s.append("}");
         }
         s.append("}");
         //System.out.println(s);
         return s.toString();
    }

    private TreeNode toNode(String s, int start, int end) {
        
        String nums = "";
        int index = start + 1;
        
        if (s.charAt(index) == 'l') {
            index += 6;
            end -= 1;
        } else if (s.charAt(index) == 'r') {
            index += 7;
            end -= 1;
        }
        while(s.charAt(index) == '-'|| Character.isDigit(s.charAt(index))) nums+=s.charAt(index++);
        if (nums.length() == 0) return null;

        TreeNode node  = new TreeNode(Integer.parseInt(nums));
        
        if (index < end) {
            if (s.substring(index, index + 6).equals("{left=")) {
                Stack<Character> closing = new Stack<Character>();
                closing.add('{');
                int endIndex = index + 1;
                while(true && endIndex <= end) {
                    if (s.charAt(endIndex) == '{') {
                        closing.add('{');
                        
                    } 
                    if (s.charAt(endIndex) == '}') {
                        closing.pop();
                        if (closing.isEmpty()) break;
                        
                    }
                    endIndex++;
                }

                node.left = toNode(s, index, endIndex);
                index = endIndex + 1;
            }
            if (index < end) {
                if (s.substring(index, index + 7).equals("{right="))
                    node.right = toNode(s, index, end - 1);
            }

            return node;

        } 


        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));