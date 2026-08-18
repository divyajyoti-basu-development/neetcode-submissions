class Solution {
    public boolean isValid(String s) {
        Stack<Character> parenStack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                parenStack.push(ch);
            } else if(ch == '{') {
                parenStack.push(ch);
            } else if(ch == '[') {
                parenStack.push(ch); 
            } else if(ch == ']' && (parenStack.size() == 0 || parenStack.pop() != '[')) {
                return false;
            } else if(ch == ')' && (parenStack.size() == 0 || parenStack.pop() != '(')) {
                return false;
            } else if(ch == '}' && (parenStack.size() == 0 || parenStack.pop() != '{')) {
                return false;
            }
        }
        return parenStack.size() == 0 ? true : false;
    }
}
