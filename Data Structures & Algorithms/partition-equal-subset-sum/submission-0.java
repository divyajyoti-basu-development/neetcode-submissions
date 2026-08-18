class Solution {

    private boolean canSum(int[] nums, int target, int index, Map<String, Boolean> memo) {
        if(target == 0) {
            return true;
        }
        if(target < 0 || index == nums.length) {
            return false;
        }
        String key = new StringBuilder().append(index).append(",").append(target).toString();
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean with = canSum(nums, target - nums[index], index + 1, memo);
        boolean without = canSum(nums, target, index + 1, memo);
        memo.put(key, with || without);
        return with || without;
    }
    public boolean canPartition(int[] nums) {
        if(nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        Map<String, Boolean> memo = new HashMap<>();
        return canSum(nums, sum / 2, 0, memo);
    }
}
