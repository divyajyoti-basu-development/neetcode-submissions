class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, current = 0, maxCount = 0, maxLength = 0;
        int[] countArr = new int[26];
        while(right < s.length()) {
            maxCount = Math.max(maxCount, ++countArr[s.charAt(right) - 'A']);
            if(right - left + 1 - maxCount <= k) {
                right++;
                maxLength = Math.max(maxLength, ++current);
            } else {
                while(right - left + 1 - maxCount > k) {
                    countArr[s.charAt(left) - 'A']--;
                    left++;
                    current--;
                }
                current++;
                right++;
            }
        }
        return maxLength;
    }
}
