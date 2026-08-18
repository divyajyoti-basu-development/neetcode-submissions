class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int card : hand) {            
            if(countMap.containsKey(card)) {
                countMap.put(card, countMap.get(card) + 1);
            } else {
                countMap.put(card, 1);
            }
        }
        countMap.forEach((k,v) -> minHeap.offer(k));
        int currentGroupSize;
        int currentCard;
        while(!minHeap.isEmpty()) {
            currentGroupSize = 0;
            currentCard = minHeap.peek();            
            while(currentGroupSize < groupSize) {
                //System.out.println("Current Card: " + currentCard);
                if(countMap.get(currentCard) == null || countMap.get(currentCard) == 0) {
                    //System.out.println("Failed at no card present");
                    return false;
                }
                if(countMap.get(currentCard) == 1) {
                    //System.out.println("Current 1 count card: " + currentCard);
                    //System.out.println("Min Card: " + minHeap.peek()); 
                    if(minHeap.peek() != currentCard) {
                        //System.out.println("Failed at no further group can be made"); 
                                              
                        return false;
                    } else {
                        minHeap.poll();                        
                    }
                }
                countMap.put(currentCard, countMap.get(currentCard) - 1);
                currentGroupSize++;
                currentCard = currentCard + 1;
            }
            System.out.println("Group Complete");
        }
        return true;
    }
}
