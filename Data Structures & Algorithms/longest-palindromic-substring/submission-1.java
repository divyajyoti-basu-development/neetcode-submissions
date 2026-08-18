class Solution {

    private int longestStart;
    private int longestLength;

    private void isPalindrome(String s, int index1, int index2) {
        while(index1 >= 0 && index2 < s.length()
            && s.charAt(index1) == s.charAt(index2)) {            
            index1--;
            index2++;
        }
        if(longestLength < (index2 - index1 - 1)) {
            longestLength = index2 - index1 - 1;
            longestStart = index1 + 1;
        }
    }

    public String longestPalindrome(String s) {
        if(s.length() < 2) {
            return s;
        }
        for(int index = 0 ; index < s.length() - 1 ; index++) {
            isPalindrome(s, index, index);
            isPalindrome(s, index, index + 1);
        }
        return s.substring(longestStart, longestStart + longestLength);
    }

}
