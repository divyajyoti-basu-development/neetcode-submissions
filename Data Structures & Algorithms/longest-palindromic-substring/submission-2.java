class Solution {

    int startIndex;
    int endIndex;

    private void findMaxPalindrome(String s, int index1, int index2) {
        while(index1 >= 0 && index2 < s.length()) {
            if(s.charAt(index1) == s.charAt(index2)) {                
                index1--;
                index2++;
            } else {
                break;
            }
        }
        if(endIndex - startIndex < (index2 - 1 - (index1 + 1))) {
            startIndex = index1 + 1;
            endIndex = index2 - 1;
        }
    }

    public String longestPalindrome(String s) {
        for(int index = 0 ; index < s.length() - 1 ; index++) {
            findMaxPalindrome(s, index, index);
            findMaxPalindrome(s, index, index + 1);
        }
        return s.substring(startIndex, endIndex + 1);
    }
}
