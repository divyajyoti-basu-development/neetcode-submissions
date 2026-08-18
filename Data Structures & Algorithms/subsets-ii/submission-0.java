class Solution {
    private void solve(int nums[], int index, List<List<Integer>> result, List<Integer> current) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Subsets with element
        current.add(nums[index]);
        solve(nums, index + 1, result, current);
        current.remove(current.size() - 1);
        // Subsets without element
        index++;
        while(index < nums.length && nums[index] == nums[index - 1]) {
            index++;
        }
        solve(nums, index, result, current);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(nums, 0, result, current);
        return result;
    }
}
