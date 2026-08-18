class Solution {

    private int recursiveGetLongestSubsequence(int[] nums, int index, int prev, int[][] memo) {
        if(index == nums.length) {
            return 0;
        }
        int prevIndex = prev < 0 ? 1000 + prev * (-1) : prev;
        if(memo[index][prevIndex] != -1) {
            return memo[index][prevIndex];
        }
        if(prev == 2002) {                     
            int countWith = 1 + recursiveGetLongestSubsequence(nums, index + 1, nums[index], memo);
            int countWithout = recursiveGetLongestSubsequence(nums, index + 1, 2002, memo);
            return memo[index][prevIndex] = Math.max(countWith, countWithout);
        } else {
            int result = 0;
            for(int position = index ; position < nums.length ; position++) {
                //int countFresh = recursiveGetLongestSubsequence(nums, index + 1, 1001, memo);
                int countContinue = 0;
                if(nums[position] > prev) {
                   countContinue = 1 + recursiveGetLongestSubsequence(nums, position + 1, nums[position], memo); 
                   result = Math.max(result, countContinue);
                }
                //result = countContinue;
            }
            return memo[index][prevIndex] = result;
        }
    }
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length + 1][2003];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // Fills every element in the current row with 10
        }
        return recursiveGetLongestSubsequence(nums, 0, 2002, memo);        
    }
}
