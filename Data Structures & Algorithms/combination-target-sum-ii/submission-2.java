class Solution {

    private void solve(int[] nums, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || index == nums.length) {
            return;
        }
        current.add(nums[index]);
        solve(nums, index + 1, target - nums[index], current, result);
        current.remove(current.size() - 1);
        int currentNumber = nums[index];
        while(index < nums.length && nums[index] == currentNumber) {
            index++;
        } 
        solve(nums, index, target, current, result);
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(nums, 0, target, current, result);
        return result;
    }
}
