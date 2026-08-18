class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for(int num : nums) {
            uniqueSet.add(num);
        }
        int max = 0, count = 0;
        for(int num : nums) {
            if(uniqueSet.contains(num + 1)) {
                continue;
            }
            count = 0;            
            while(uniqueSet.contains(num)) {
                count++;
                num--;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
