class Solution {

    private void solve(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int pos = 0 ; pos < nums.length ; pos++) {
            if(!visited[pos]) {
                current.add(nums[pos]);
                visited[pos] = true;
                solve(nums, visited, current, result);
                visited[pos] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums, visited, current, result);
        return result;
    }
}
