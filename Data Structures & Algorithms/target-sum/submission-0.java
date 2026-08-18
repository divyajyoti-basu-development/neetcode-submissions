class Solution {

    private int recursiveTargetSum(int[] nums, int target, int index, int currentSum, Map<String, Integer> memo) {
        if(currentSum == target && index == nums.length) {
            return 1;
        }               
        if(index == nums.length) {
            return 0;
        }
        String key = new StringBuilder().append(index).append(",").append(currentSum).toString();
        if(memo.containsKey(key)) {
            return memo.get(key);
        } 
        int add = recursiveTargetSum(nums, target, index + 1, currentSum + nums[index], memo);
        int subtract = recursiveTargetSum(nums, target, index + 1, currentSum - nums[index], memo);
        memo.put(key, add + subtract);
        return add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return recursiveTargetSum(nums, target, 0, 0, memo);
    }

}
