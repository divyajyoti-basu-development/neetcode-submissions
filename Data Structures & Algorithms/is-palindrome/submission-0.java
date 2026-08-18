class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        int counter = 0;
        while(left < right) {
            //System.out.println("Counter: " + counter++);
            //System.out.println("Left Char: " + s.charAt(left));
            //System.out.println("Right Char: " + s.charAt(right));
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++; 
                continue;               
            }
            if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--; 
                continue;                
            }
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
