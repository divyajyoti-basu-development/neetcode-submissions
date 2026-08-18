class Solution {

    private int solve(int[] nums, int target, int index, Map<String, Integer> memo) {
        if(target == 0 && index == nums.length) {
            return 1;
        }
        if(index == nums.length) {
            return 0;
        }
        String key = index + "#" + target;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int countAdd = solve(nums, target + nums[index], index + 1, memo);
        int countSubtract = solve(nums, target - nums[index], index + 1, memo);
        memo.put(key, countAdd + countSubtract);
        return countAdd + countSubtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(nums, target, 0, memo);
    }
}
