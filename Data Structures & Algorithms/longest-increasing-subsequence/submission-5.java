class Solution {

    private int getMaxLis(int[] nums, int index, int prev, Map<String, Integer> memo) {
        if(index == nums.length) {
            return 0;
        }

        String key = new StringBuilder().append(index).append("#").append(prev).toString();
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        // Start fresh subsequence
        if(prev == Integer.MAX_VALUE) {
            int containsIndex = 1 + getMaxLis(nums, index + 1, nums[index], memo);
            int noIndex = getMaxLis(nums, index + 1, Integer.MAX_VALUE, memo);
            memo.put(key, Math.max(containsIndex, noIndex));
            return Math.max(containsIndex, noIndex);
        }
        else {
            int result = 0;
            for(int position = index ; position < nums.length ; position++) {
                //int countFresh = recursiveGetLongestSubsequence(nums, index + 1, 1001, memo);
                int countContinue = 0;
                if(nums[position] > prev) {
                   countContinue = 1 + getMaxLis(nums, position + 1, nums[position], memo); 
                   result = Math.max(result, countContinue);
                }
                //result = countContinue;
            }
			memo.put(key, result);
            return result;
        }   
    }

    public int lengthOfLIS(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();
        return getMaxLis(nums, 0, Integer.MAX_VALUE, memo);
    }
}
