public class Stack {
    
    public Node head;
    // Push element x onto stack.
    public void Push(int x) 
    {
        Node node = new Node(x);
        if(head == null)
        {
            head = node;
            
        }
        else 
        {
            node.PreviousNode = head;
            head = node;
        }
    }

    // Removes the element on top of the stack.
    public void Pop() {
        if(head != null)
        {
            head = head.PreviousNode;
        }
    }

    // Get the top element.
    public int Top() {
        return head.data;
    }

    // Return whether the stack is empty.
    public bool Empty() {
        return head == null;
    }
    
    public class Node
    {
        public int data;
        public Node PreviousNode;
        
        public Node(int val)
        {
            data = val;
            PreviousNode = null;
        }
    }
}