class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int max = 0, currentSize;
        for(int num : nums) {
            numSet.add(num);
        }
        int temp;
        for(int num : numSet) {
            if(numSet.contains(num + 1)) {
                continue;
            } else {
                currentSize = 0;
                temp = num;
                while(numSet.contains(temp)) {
                    currentSize++;
                    temp--;
                }
                max = Math.max(max, currentSize);
            }
        }
        return max;
    }
}
