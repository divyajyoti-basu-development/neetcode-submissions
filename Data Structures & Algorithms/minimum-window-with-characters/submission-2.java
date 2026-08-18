class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> windowCountMap = new HashMap<>();
        Map<Character, Integer> targetCountMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            targetCountMap.put(c, targetCountMap.getOrDefault(c, 0) + 1);
            windowCountMap.put(c, 0);
        }

        int left = 0;
        int resultStart = 0, resultLength = Integer.MAX_VALUE;
        int have = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (targetCountMap.containsKey(c)) {
                windowCountMap.put(c, windowCountMap.get(c) + 1);
                if (windowCountMap.get(c).intValue() == targetCountMap.get(c).intValue()) {
                    have++;
                }
            }

            while (have == targetCountMap.size()) {
                if (right - left + 1 < resultLength) {
                    resultLength = right - left + 1;
                    resultStart = left;
                }

                char leftChar = s.charAt(left);
                if (targetCountMap.containsKey(leftChar)) {
                    windowCountMap.put(leftChar, windowCountMap.get(leftChar) - 1);
                    if (windowCountMap.get(leftChar) < targetCountMap.get(leftChar)) {
                        have--;
                    }
                }
                left++;
            }
        }

        return resultLength == Integer.MAX_VALUE
            ? ""
            : s.substring(resultStart, resultStart + resultLength);
    }
}
