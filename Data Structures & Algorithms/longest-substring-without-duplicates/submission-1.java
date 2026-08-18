class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueSet = new HashSet<>();
        int left = 0, right = 0, length = 0;
        while(right < s.length()) {
            if(!uniqueSet.contains(s.charAt(right))) {
                length = Math.max(length, right - left + 1);                
                uniqueSet.add(s.charAt(right));
                right++;                
            } else {
                while(uniqueSet.contains(s.charAt(right))) {
                    uniqueSet.remove(s.charAt(left));
                    left++;
                }
                uniqueSet.add(s.charAt(right));
                right++;
            }
        }
        return length;
    }
}
