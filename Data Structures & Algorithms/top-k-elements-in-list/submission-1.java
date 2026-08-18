class Solution {

    public class Pair {
        public int val;
        public int count;

        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.count - b.count);
        for(int number : nums) {
            if(!countMap.containsKey(number)) {
                countMap.put(number, 0);
            }
            countMap.put(number, countMap.get(number) + 1);            
        }
        countMap.forEach((key, v) -> {
            if(minHeap.size() < k) {
                minHeap.offer(new Pair(key, v));
            } else {
                if(v > minHeap.peek().count) {
                    minHeap.poll();
                    minHeap.offer(new Pair(key, v));
                }
            }
        });
        int[] result = new int[k];
        for(int index = 0 ; index < k ; index++) {
            result[index] = minHeap.poll().val;
        }
        return result;
    }
}
