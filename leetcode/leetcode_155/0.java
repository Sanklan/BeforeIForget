class MinStack {
    Stack<Integer> data;
    Stack<Integer> mins;
    public MinStack() {
        data = new Stack<Integer>();
        mins = new Stack<Integer>();
    }
    
    public void push(int val) {
        if (data.isEmpty()) {
            data.push(val);
            mins.push(val);
        }
        else {
            data.push(val);
            if (mins.peek() > val) mins.push(val);
            else mins.push(mins.peek());
        }
    }
    
    public void pop() {
        data.pop();
        mins.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */