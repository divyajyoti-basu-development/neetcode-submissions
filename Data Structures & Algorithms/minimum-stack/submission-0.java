class MinStack {

    private class Element {
        public int element;
        public int min;

        public Element(int element, int min) {
            this.element = element;
            this.min = min;
        }
    }

    Stack<Element> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(minStack.size() == 0) {
           minStack.push(new Element(val, val)); 
        } else {
            minStack.push(new Element(val, minStack.peek().min < val ? minStack.peek().min : val));
        }
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek().element;
    }
    
    public int getMin() {
        return minStack.peek().min;
    }

}
