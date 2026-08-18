class Solution {

    int count;

    private void countPalindromes(String s, int index1, int index2) {
        while(index1 >= 0 && index2 < s.length()) {
            if(s.charAt(index1--) != s.charAt(index2++)) {
                break;
            }
            count++;
        }
    }
    public int countSubstrings(String s) {
        for(int index = 0 ; index < s.length() ; index++) {
            countPalindromes(s, index, index);
            countPalindromes(s, index, index + 1);
        }
        return count;
    }
}
