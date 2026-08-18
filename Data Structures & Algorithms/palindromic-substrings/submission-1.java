class Solution {

    int count;
   
    private void countPalindromes(String s, int index1, int index2) {
        while(index1 >= 0 && index2 < s.length()
            && s.charAt(index1) == s.charAt(index2)) {
                count++;
                index1--;
                index2++;
            }
    }
    public int countSubstrings(String s) {
        if(s.length() >= 1) {
            count++;
        }
        for(int index = 0 ; index < s.length() - 1 ; index++) {
            countPalindromes(s, index, index);
            countPalindromes(s, index, index + 1);
        }  
        return count;      
    }
}
