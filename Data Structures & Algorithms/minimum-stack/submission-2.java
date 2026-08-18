class MinStack {

    private class Node{
        public int val;
        public int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

    }

    private Stack<Node> internalStack;

    public MinStack() {
        internalStack = new Stack<>();
    }
    
    public void push(int val) {
        if(internalStack.size() > 0) {
            internalStack.push(new Node(val, Math.min(internalStack.peek().min, val)));
        } else {
            internalStack.push(new Node(val, val));
        }
    }
    
    public void pop() {
        internalStack.pop();
    }
    
    public int top() {
        return  internalStack.peek().val;
    }
    
    public int getMin() {
        return internalStack.peek().min;
    }
}
