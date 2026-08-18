class Solution {

    private void solve(List<List<Integer>> result, List<Integer> current, int target, int index, int[] nums) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || index == nums.length) {
            return;
        }
        current.add(nums[index]);
        solve(result, current, target - nums[index], index + 1, nums);
        current.remove(current.size() - 1);
        while(index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        solve(result, current, target, index + 1, nums);        
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        solve(result, current, target, 0, candidates);
        return result;
    }
}
