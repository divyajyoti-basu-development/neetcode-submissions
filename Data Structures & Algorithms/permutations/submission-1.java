class Solution {

    private void solve(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> current) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        Set<Integer> uniqueNumber = new HashSet<>();
        for(int position = 0 ; position < nums.length ; position++) {
            if(!visited[position] && !uniqueNumber.contains(nums[position])) {
                visited[position] = true;
                uniqueNumber.add(nums[position]);
                current.add(nums[position]);
                solve(nums, visited, result, current);
                current.remove(current.size() - 1);
                visited[position] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums, visited, result, current);
        return result;
    }
}
