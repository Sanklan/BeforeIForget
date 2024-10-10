/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map = new HashMap<Integer, Node>();
        return clone(node);
    }
    HashMap<Integer, Node> map;
    private Node clone(Node node) {
        Node nodeClone = new Node(node.val);
        map.put(node.val, nodeClone);
        Node neighClone;
        for(Node neigh:node.neighbors) {
            if (map.containsKey(neigh.val)) {
                neighClone = map.get(neigh.val);
            } else {
                neighClone = clone(neigh);
            }
            nodeClone.neighbors.add(neighClone);
        }

        return nodeClone;
    }
}