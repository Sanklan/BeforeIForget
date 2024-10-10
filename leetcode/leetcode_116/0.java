/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Stack<Node> stack = new Stack<Node>();
        if (root == null) return root;
        stack.push(root);
        boolean odd = false;
        while (!stack.empty()) {
            Stack<Node> queue = new Stack<Node>();
            Node prev = null;
           // System.out.print("Stack is ");
            while(!stack.empty()) {
                Node node = stack.pop();
                if (prev != null) {
                    prev.next = node;
                }
             //   System.out.print(node.val + ",");
                prev = node;                  
                if (node.right != null) queue.push(node.left); 
                if (node.left != null) queue.push(node.right);  
                        
            }
          //  System.out.println();
            while(!queue.empty()) {
                Node node = queue.pop();
             //   System.out.print(node.val + "<-");
                stack.push(node);
            }
           // System.out.println("");            
        }
        
        return root;
    }
}