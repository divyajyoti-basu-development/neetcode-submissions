class Solution {

    private int solveLis(int[] nums, int index, Map<String, Integer> memo, int prev) {
        if(index == nums.length) {
            return 0;
        }
        String key = index + "#" + prev;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(prev == 1001) {
            int lisWith = 1 + solveLis(nums, index + 1, memo, nums[index]);
            int lisWithout = solveLis(nums, index + 1, memo, 1001);
            memo.put(key, Math.max(lisWith, lisWithout));
            return memo.get(key);
        }
        int lisWith = 0;
        for(int pos = index; pos < nums.length ; pos++) {
            if(nums[pos] > prev) {
                lisWith = Math.max(lisWith, 1 + solveLis(nums, pos + 1, memo, nums[pos]));
            }
        }
        memo.put(key, lisWith);
        return lisWith;
    }

    public int lengthOfLIS(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();
        return solveLis(nums, 0, memo, 1001);
    }

}
