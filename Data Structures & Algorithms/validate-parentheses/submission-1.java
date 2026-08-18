class Solution {
    public boolean isValid(String s) {
        Stack<Character> parenthesisStack = new Stack<>();
        for(Character ch : s.toCharArray()) {
            if(ch == ')') {
                if(parenthesisStack.size() == 0 || parenthesisStack.pop() != '(') {
                    return false;
                }
            } else if(ch == '}') {
                if(parenthesisStack.size() == 0 || parenthesisStack.pop() != '{') {
                    return false;
                }
            } else if(ch == ']') {
                if(parenthesisStack.size() == 0 || parenthesisStack.pop() != '[') {
                    return false;
                }
            } else {
                parenthesisStack.push(ch);
            }
        }        
        return parenthesisStack.size() == 0 ? true : false;
    }
}    
