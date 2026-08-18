class Solution {

    private int startIndex;
    private int endIndex;
    private int maxPalin;
    public String longestPalindrome(String s) {
        int maxPalin = 0;
        for(int index = 0 ; index < s.length() - 1 ; index++) {
            getPalindromeLength(s, index, index);
            getPalindromeLength(s, index, index + 1);
        }
        return s.substring(startIndex, endIndex + 1);
    }

    private void getPalindromeLength(String s, int start1, int start2) {
        while(start1 >= 0 && start2 < s.length() && s.charAt(start1) == s.charAt(start2)) {
            start2++;
            start1--;
        }
        if(start2 - start1 - 1 > maxPalin) {
            maxPalin = start2 - start1 - 1;
            startIndex = start1 + 1;
            endIndex = start2 - 1;
        }
    }
}