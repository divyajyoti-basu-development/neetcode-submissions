class Solution {

    private void solve(List<Integer> current, int index, int[] nums, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        solve(current, index + 1, nums, result);
        current.add(nums[index]);
        solve(current, index + 1, nums, result);
        current.remove(current.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(current, 0, nums, result);
        return result;
    }
}
