class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] countArr = new List[nums.length + 1];
        for(int num : nums) {
            if(countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(countArr[entry.getValue()] == null) {
                countArr[entry.getValue()] = new ArrayList<Integer>();                
            } 
            countArr[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int counter = 0;
        for(int index = nums.length ; index > - 1 && counter < k ; index--) {
            if (countArr[index] == null) continue;
            for (int number : countArr[index]) {
                result[counter] = number;
                counter++;
                if (counter == k) break;
            }
        }
        return result;
    }
}
