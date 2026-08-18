class Solution {

    private void solve(int[] nums, int index, List<Integer> current, List<List<Integer>> result, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || index == nums.length) {
            return;
        }
        solve(nums, index + 1, current, result, target);
        current.add(nums[index]);
        solve(nums, index, current, result, target - nums[index]);
        current.remove(current.size() - 1);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(nums, 0, current, result, target);
        return result;
    }
}
