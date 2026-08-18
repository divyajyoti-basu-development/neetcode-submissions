class Solution {
    public String minWindow(String s, String t) {
        Set<Character> lettersSet = new HashSet<>();
        Map<Character, Integer> windowCountMap = new HashMap<>();
        Map<Character, Integer> targetCountMap = new HashMap<>();
        int left = 0, right = 0;
        int resultStart = 0, resultEnd = 0, resultLength = Integer.MAX_VALUE;
        for(char letter : t.toCharArray()) {
            windowCountMap.put(letter, 0);            
            if(targetCountMap.containsKey(letter)) {
                targetCountMap.put(letter, targetCountMap.get(letter) + 1);
            } else {
                targetCountMap.put(letter, 1);
            }
        }
        //System.out.println("Target Map:" + targetCountMap);
        int have = 0;
        char currentLetter;
        while(right < s.length()) {
            currentLetter = s.charAt(right);
            if(targetCountMap.containsKey(currentLetter)) {
                windowCountMap.put(currentLetter, windowCountMap.get(currentLetter) + 1);
                if(windowCountMap.get(currentLetter) == targetCountMap.get(currentLetter)) {
                    have++;
                }
            }
            if(have == targetCountMap.size()) {
                //System.out.println("Valid at: " + right);
                boolean validFlag = true;
                while(validFlag) {
                    if(windowCountMap.containsKey(s.charAt(left))) { 
                        if(windowCountMap.get(s.charAt(left)) > targetCountMap.get(s.charAt(left))) {
                            windowCountMap.put(s.charAt(left), windowCountMap.get(s.charAt(left)) - 1);
                            left++;
                        }
                        else validFlag = false;                    
                    } else {
                        left++;
                    }
                }
                if(right - left + 1 < resultLength) {
                    resultLength = right - left + 1;
                    resultStart = left;
                    resultEnd = right;
                }
            }
            right++;
        }
        return have == targetCountMap.size() ? s.substring(resultStart, resultEnd + 1) : "";
    }
}
