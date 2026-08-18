class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for(int index = 0 ; index < s.length() ; index++) {
            if(s.charAt(index) == ')') {
                leftMax--;
                leftMin--;
            }            
            else if(s.charAt(index) == '(') {
                leftMax++;      
                leftMin++;
            }      
            else if(s.charAt(index) == '*') {
                leftMax++;
                leftMin = Math.max(0, leftMin-1);
            }
            if(leftMax < 0 ) return false;
        }
        return leftMin <= 0 && 0 <= leftMax ? true : false;
    }
}