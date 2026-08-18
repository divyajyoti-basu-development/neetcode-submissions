class Solution {
    public String minWindow(String s, String t) {
        int matchCount = 0, left = 0, right = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> currentCount = new HashMap<>();
        for(char ch : t.toCharArray()) {
            if(!countMap.containsKey(ch)) {
                countMap.put(ch, 1);
                currentCount.put(ch, 0);
            }
            else countMap.put(ch, countMap.get(ch) + 1);
        }
        int result = Integer.MAX_VALUE;
        int leftIndex = 0, rightIndex = -1;
        Set<Character> matchSet = new HashSet<>();
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(!countMap.containsKey(ch)) {
                right++;
                continue;
            }
            currentCount.put(ch, currentCount.get(ch) + 1);
            if(matchSet.contains(ch)
             || currentCount.get(ch) < countMap.get(ch)) {
                right++;
                continue;
             }
            if(currentCount.get(ch) == countMap.get(ch)) {
                matchSet.add(ch);
                matchCount++;
            }
            while(matchCount == countMap.size()) {
                if(right - left + 1 < result) {
                    result = right - left + 1;
                    rightIndex = right;
                    leftIndex = left;
                }
                char moving = s.charAt(left);
                if(!countMap.containsKey(moving)) {
                    left++;
                    continue;
                }
                currentCount.put(moving, currentCount.get(moving) - 1);
                if(currentCount.get(moving) < countMap.get(moving)) {
                    matchSet.remove(moving);
                    matchCount--;
                }
                left++;
            }
            right++;
        }
        return rightIndex == -1 ? "" : s.substring(leftIndex, rightIndex + 1);
    }
}
