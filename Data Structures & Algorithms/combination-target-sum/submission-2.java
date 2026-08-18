class Solution {

    private void solve(List<List<Integer>> result, List<Integer> current, int remainder, int index, int[] nums) {
        if(remainder == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(remainder < 0 || index == nums.length) {
            return;
        }
        solve(result, current, remainder, index + 1, nums);
        current.add(nums[index]);
        solve(result, current, remainder - nums[index], index , nums);
        current.remove(current.size() - 1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(result, current, target, 0, nums);
        return result;
    }
}
