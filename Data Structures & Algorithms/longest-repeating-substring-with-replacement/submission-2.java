class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = 0, maxCount = 0;
        int[] countArray = new int[26];
        while(right < s.length()) {            ;
            maxCount = Math.max(maxCount, countArray[s.charAt(right) - 'A'] + 1);
            if(right - left + 1 - maxCount <= k) {
                countArray[s.charAt(right) - 'A']++;
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                while(right - left + 1 - maxCount > k) {
                    countArray[s.charAt(left) - 'A']--;
                    left++;
                }
                countArray[s.charAt(right) - 'A']++;
                right++;
            }
        }
        return max;
    }
}
