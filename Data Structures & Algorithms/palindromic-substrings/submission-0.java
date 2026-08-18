class Solution {

    private int result;    

    private void isPalindrome(String s, int start1, int start2) {
        while(start1 >= 0 && start2 < s.length() && s.charAt(start1) == s.charAt(start2)) {
            start1--;
            start2++;
            result++;
        }        
    }
    public int countSubstrings(String s) {
        for(int index = 0 ; index < s.length() - 1; index++) {
            isPalindrome(s, index, index);
            isPalindrome(s, index, index + 1);
        }
        return result + 1;
    }
}