class Solution {

    private void solve(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        solve(nums, index + 1, result, current);
        current.remove(current.size() - 1);
        int position = index + 1;
        while(position < nums.length && nums[index] == nums[position]) {
            position++;
        }        
        solve(nums, position, result, current);        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, result, current);
        return result;
    }
}
