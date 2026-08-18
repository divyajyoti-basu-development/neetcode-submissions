class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, result = 0, current = 0;
        Set<Character> uniqueSet = new HashSet<>();
        while(right < s.length()) {
           if(!uniqueSet.contains(s.charAt(right))) {
                uniqueSet.add(s.charAt(right));
                current++;
                right++;
                result = Math.max(result, current);
           } else {
                while(uniqueSet.contains(s.charAt(right))) {
                    uniqueSet.remove(s.charAt(left));
                    left++;
                    current--;
                }
                uniqueSet.add(s.charAt(right));
                current++;
                right++;
           }
        }
        return result;
    }
}
