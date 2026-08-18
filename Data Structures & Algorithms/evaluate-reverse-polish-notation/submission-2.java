class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> exprStack = new Stack<>();
        int first, second;
        for(String token : tokens) {
            if(token.equals("+")) {
                second = Integer.valueOf(exprStack.pop());
                first = Integer.valueOf(exprStack.pop());
                exprStack.push(first + second);
            } else if(token.equals("-")) {
                second = Integer.valueOf(exprStack.pop());
                first = Integer.valueOf(exprStack.pop());
                exprStack.push(first - second);
            } else if(token.equals("*")) {
                second = Integer.valueOf(exprStack.pop());
                first = Integer.valueOf(exprStack.pop());
                exprStack.push(first * second);
            }  else if(token.equals("/")) {
                second = Integer.valueOf(exprStack.pop());
                first = Integer.valueOf(exprStack.pop());
                exprStack.push(first / second);
            } else {
                exprStack.push(Integer.valueOf(token));
            }
        }
        return exprStack.pop();
    }
}
