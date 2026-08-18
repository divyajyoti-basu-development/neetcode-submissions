class Solution {

    private boolean checkSubStringMatch(Map<Character, Integer> s2CountMap, Map<Character, Integer> s1CountMap) {
        for(Map.Entry<Character, Integer> entry : s1CountMap.entrySet()) {
            if(s2CountMap.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }   
        return true;       
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> s1CountMap = new HashMap<>();
        Map<Character, Integer> s2CountMap = new HashMap<>();
        for(char ch : s1.toCharArray()) {
            if(!s1CountMap.containsKey(ch)) {
                s1CountMap.put(ch, 0);
            }
            s1CountMap.put(ch, s1CountMap.get(ch) + 1);
        }
        int left = 0, right = 0;
        while(right < s2.length()) {
            if(!s2CountMap.containsKey(s2.charAt(right))) {
                s2CountMap.put(s2.charAt(right), 0);
            }
            s2CountMap.put(s2.charAt(right), s2CountMap.get(s2.charAt(right)) + 1);
            if(right - left + 1 < s1.length()) {
                right++;
            } else if(checkSubStringMatch(s2CountMap, s1CountMap)){
                return true;
            } else {
                s2CountMap.put(s2.charAt(left), s2CountMap.get(s2.charAt(left)) - 1);
                left++;
                right++;
            }
        }
        return false;
    }
}
