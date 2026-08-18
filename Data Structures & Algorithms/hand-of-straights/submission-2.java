class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        if(hand.length % groupSize != 0) {
            return false;
        }
        for(int card : hand) {
            if(!countMap.containsKey(card)) {
                countMap.put(card, 1);
            } else {
                countMap.put(card, countMap.get(card) + 1);
            }
        }
        while(true) {            
            Map.Entry<Integer, Integer> firstEntry = countMap.firstEntry();
            if(firstEntry == null) {
                return true;
            }
            int prev = firstEntry.getKey();
            int currentGroupSize = 1;            
            if(firstEntry.getValue() == 1) {
                countMap.remove(prev);
            } else {
                countMap.put(prev, countMap.get(prev) - 1);
            }
            while(currentGroupSize != groupSize) {
                if(!countMap.containsKey(prev + 1)) {
                    return false;
                } else {
                    prev = prev + 1;
                    currentGroupSize++;
                    if(countMap.get(prev) == 1) {
                        countMap.remove(prev);
                    } else {
                        countMap.put(prev, countMap.get(prev) - 1);
                    }
                }
            }
        }
        //return true;
    }
}