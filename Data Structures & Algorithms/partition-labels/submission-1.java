class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> charMaxIndexMap = new HashMap<>();
        for(int index = 0 ; index < s.length() ; index++) {
            charMaxIndexMap.put(s.charAt(index), index);
        }
        int currentSize = 0;
        int maxCharIndex = 0;
        List<Integer> result = new ArrayList<>();
        for(int index = 0 ; index < s.length() ; index++) {
            currentSize++;
            maxCharIndex = Math.max(maxCharIndex, charMaxIndexMap.get(s.charAt(index)));
            if(index == maxCharIndex) {
                result.add(currentSize);
                currentSize = 0;
            }
        }
        return result;
    }
}
