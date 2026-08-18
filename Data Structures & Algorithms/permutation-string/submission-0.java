class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }
        int left = 0, right = 0;
        int[] countArr = new int[26];
        Map<Character, Integer> countMap = new HashMap<>();
        for(char ch : s1.toCharArray()) {
            if(!countMap.containsKey(ch)) {
                countMap.put(ch, 0);
            }
            countMap.put(ch, countMap.get(ch) + 1);
        }
        //System.out.println("Count Map: " + countMap);
        while(right < s2.length()) {
            if(!countMap.containsKey(s2.charAt(right))) {
                Arrays.fill(countArr, 0);
                right++;
                left = right;
            } else if(right - left + 1 == s1.length()){
                countArr[s2.charAt(right) - 'a']++;
                if(checkMatch(countArr, countMap)) {
                    return true;
                } else {
                    countArr[s2.charAt(left) - 'a']--;
                    left++;  
                    right++;                  
                }
            } else {
                countArr[s2.charAt(right) - 'a']++;
                right++;
            }
        }
        return false;
    }

    private boolean checkMatch(int[] countArr, Map<Character, Integer> countMap) {
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if(countArr[entry.getKey() - 'a'] != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
