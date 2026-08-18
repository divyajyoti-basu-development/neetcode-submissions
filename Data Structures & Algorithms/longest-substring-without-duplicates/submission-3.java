class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueCharSet = new HashSet<>();
        int left = 0, right = 0, maxlength = 0, current = 0;
        while(right < s.length()) {
            if(!uniqueCharSet.contains(s.charAt(right))) {                
                uniqueCharSet.add(s.charAt(right));
                right++;
                current++;
                maxlength = Math.max(maxlength, current);
            } else {
                while(uniqueCharSet.contains(s.charAt(right))) {
                    uniqueCharSet.remove(s.charAt(left));
                    left++;
                    current--;
                }
                uniqueCharSet.add(s.charAt(right));
                current++;
                right++;
            }
        }
        return maxlength;
    }
}
