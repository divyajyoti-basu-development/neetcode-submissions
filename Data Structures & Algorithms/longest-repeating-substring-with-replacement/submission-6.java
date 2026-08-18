class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0, current = 0;
        int left = 0, right = 0, maxCount = 0;
        int[] countArr = new int[26];
        while(right < s.length()) {
            maxCount = Math.max(maxCount, ++countArr[s.charAt(right) - 'A']);
            if(right - left + 1 - k <= maxCount) {                current++;
                
                result = Math.max(result, current);
            } else {
                //current--;                
                --countArr[s.charAt(left)- 'A'];
                left++;
            }
            right++;
        }
        return result;
    }
}
