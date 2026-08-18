class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastPosMap = new HashMap<>();
        char currentChar;
        for(int index = 0 ; index < s.length() ; index++) {            
            lastPosMap.put(s.charAt(index), index);            
        }
        int currentMax = 0;
        int currentGroupSize = 0;        
        List<Integer> groupsList = new ArrayList<>();        
        for(int index = 0 ; index < s.length() ; index++) {            
            currentMax = Math.max(currentMax, lastPosMap.get(s.charAt(index)));
            currentGroupSize++;
            if(index == currentMax) {
                groupsList.add(currentGroupSize);
                currentGroupSize = 0;
            }
        }
        return groupsList;
    }
}