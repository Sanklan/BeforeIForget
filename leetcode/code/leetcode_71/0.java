class Solution {
    public String simplifyPath(String path) {
       
        int index = 0;
        int length = path.length();
        Node root = new Node("/", null);
        Node current = root;
        while(index < length) {
            while(index < length && path.charAt(index) == '/') index++;
            if (index == length) break;
            int nextIndex = index;
            while(nextIndex < length && path.charAt(nextIndex) != '/') nextIndex++;
            
            String currentDir = path.substring(index, nextIndex);
            if (currentDir.equals(".")) {
                
            }
            else if (currentDir.equals("..")) {
                if (current.parent != null) {
                    current = current.parent;
                    current.child = null;
                }
            } else {
                Node newNode = new Node(currentDir, current);
                current.child = newNode;
                current = newNode;
            }
            index = nextIndex;
        }

        StringBuilder strbuilder = new StringBuilder();
        strbuilder.append("/");
        root = root.child;
        while(root != null) {
            strbuilder.append(root.toString());
            root = root.child;
        }

        return strbuilder.toString();
    }
}


class Node {
    String name;
    Node parent;
    Node child;

    public Node() {
        name = ".";
    }
    public Node(Node parent) {
        name = ".";
        this.parent = parent;
    }

    public Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
    }

    public String toString() {
        return name + ((child != null) ? "/" : "");
    }
}