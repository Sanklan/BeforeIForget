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
        if (root == null) return null;

        int count = 1, temp;
        LinkedList<Node> bfs = new LinkedList<Node>();
        Node prev;
        bfs.add(root);
        while(!bfs.isEmpty()) {
            prev = bfs.poll();
            temp = 0;
            while(count > 0) {
                if (prev.left != null) {
                    temp++;
                    bfs.add(prev.left);
                }
                if (prev.right != null) {
                    temp++;
                    bfs.add(prev.right);
                }
                if (count > 1) {
                    prev.next = bfs.peek();
                    prev = bfs.poll();
                }
                count--;
            }
            count = temp;
        }

        return root;
    }
}