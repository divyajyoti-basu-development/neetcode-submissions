class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> resultStack = new Stack<>();
        int a;
        for(String token : tokens) {
            if(token.equals("+")) {
                resultStack.push(resultStack.pop() + resultStack.pop());
            } else if(token.equals("*")) {
                resultStack.push(resultStack.pop() * resultStack.pop());
            } else if(token.equals("-")) {
                a = resultStack.pop();
                resultStack.push(resultStack.pop() - a);
            } else if(token.equals("/")) {
                a = resultStack.pop();
                resultStack.push(resultStack.pop() / a);
            } else {
                resultStack.push(Integer.valueOf(token));
            }
        }
        return resultStack.pop();
    }
}
