class Solution {

    private boolean canSum(int[] nums, int index, int amount, Map<Integer, Boolean> memo) {
        if(amount == 0) {
            return true;
        }
        if(amount < 0 || index == nums.length) {
            return false;
        }
        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }
        Boolean result = canSum(nums, index + 1, amount - nums[index], memo) ||
            canSum(nums, index + 1, amount, memo);
        memo.put(amount, result);
        return result;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        Map<Integer, Boolean> memo = new HashMap<>();
        return canSum(nums, 0, sum / 2, memo);
    }
}
