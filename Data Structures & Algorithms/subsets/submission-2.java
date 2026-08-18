class Solution {

    private void solve(List<Integer> current, List<List<Integer>> result, int index, int[] nums) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }        
        solve(current, result, index + 1, nums);
        current.add(nums[index]);
        solve(current, result, index + 1, nums);
        current.remove(current.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(new ArrayList<>(), result, 0, nums);
        return result;
    }

}
