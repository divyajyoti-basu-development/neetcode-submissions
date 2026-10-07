class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] countArr = new int[26];
        for(int index = 0 ; index < s.length() ; index++) {
            countArr[s.charAt(index) - 'a']++;
            countArr[t.charAt(index) - 'a']--;
        }
        for(int count : countArr) {
            if(count != 0) return false;
        }
        return true;
    }
}
