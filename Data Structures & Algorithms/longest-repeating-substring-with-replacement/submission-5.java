class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, result = 0, maxCount = 0;
        int[] countArr = new int[26];
        while(right < s.length()) {
            maxCount = Math.max(maxCount, ++countArr[s.charAt(right) - 'A']);
            if(right - left + 1 - maxCount <= k) {
                result = Math.max(result, right - left + 1);
                right++;
            } else {
                --countArr[s.charAt(left) - 'A'];
                left++;
                right++;
            }
        }
        return result;
    }
}
