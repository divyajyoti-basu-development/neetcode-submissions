class Solution {

    private void solve(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        solve(nums, index + 1, current, result);
        current.remove(current.size() - 1);
        index++;
        while(index < nums.length && nums[index] == nums[index - 1]) {
            index++;
        }
        solve(nums, index, current, result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(nums, 0, current, result);
        return result;
    }
}
