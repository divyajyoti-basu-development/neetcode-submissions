class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, right = 0, result = 0;
        char ch;
        while(right < s.length()) {
            ch = s.charAt(right);
            if(!charSet.contains(ch)) {
                result = Math.max(result, right - left + 1);
                charSet.add(ch);                
            } else {
                while(charSet.contains(ch)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(ch);
            }
            right++;
        }
        return result;
    }
}
