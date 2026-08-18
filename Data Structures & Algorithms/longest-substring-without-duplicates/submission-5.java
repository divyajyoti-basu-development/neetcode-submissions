class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueCharSet = new HashSet<>();
        int left = 0, right = 0, result = 0;
        while(right < s.length()) {
            if(!uniqueCharSet.contains(s.charAt(right))) {
                uniqueCharSet.add(s.charAt(right));
                right++;                
            } else {                
                while(uniqueCharSet.contains(s.charAt(right))) {
                    uniqueCharSet.remove(s.charAt(left));
                    left++;
                }
                uniqueCharSet.add(s.charAt(right));
                right++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}
