class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for(int num : nums) {
            uniqueSet.add(num);
        }
        int result = 0;
        for(int num : nums) {
            if(uniqueSet.contains(num + 1)) {
                continue;
            }
            int largest = 1;
            num--;
            while(uniqueSet.contains(num)) {
                largest++;
                num--;
            }
            result = Math.max(result, largest);
        }
        return result;
    }
}
