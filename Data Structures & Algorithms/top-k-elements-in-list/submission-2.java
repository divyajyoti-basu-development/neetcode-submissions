class Solution {

    private class CountNode {

        public int val;
        public int count;

        public CountNode(int val, int count) {
            this.val = val;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<CountNode> minHeap = new PriorityQueue<>(Comparator.comparing(CountNode :: getCount));

        for(int num : nums) {
            if(!countMap.containsKey(num)) {
                countMap.put(num, 0);
            }
            countMap.put(num, countMap.get(num) + 1);            
        }

        countMap.forEach((key, v) -> {
            if(minHeap.size() < k) {
                minHeap.offer(new CountNode(key, v));
            } else if(v > minHeap.peek().getCount()) {
                minHeap.poll();
                minHeap.offer(new CountNode(key, v));
            }
            
        });

        int[] result = new int[k];

        for(int index = 0 ; index < k ; index++) {
            result[index] = minHeap.poll().val;            
        }

        return result;
    }
}
