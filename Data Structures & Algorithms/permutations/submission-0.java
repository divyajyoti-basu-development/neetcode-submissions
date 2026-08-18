class Solution {

    private void solve(int[] nums, List<List<Integer>> result
    , List<Integer> current, boolean[] visited) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        Set<Integer> uniqueInts = new HashSet<>();
        for(int index = 0 ; index < nums.length ; index++) {
            if(!uniqueInts.contains(nums[index]) && ! visited[index]) {
                uniqueInts.add(nums[index]);
                visited[index] = true;
                current.add(nums[index]);
                solve(nums, result, current, visited);
                current.remove(current.size() - 1);
                visited[index] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(nums, result, current, visited);
        return result;
    }
}
