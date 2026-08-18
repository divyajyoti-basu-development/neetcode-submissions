class Solution {

    private void solve(int[] candidates, int target, int index, List<List<Integer>> result
    ,List<Integer> current) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || index == candidates.length) {
            return;
        }
        int position = index + 1;
        while(position < candidates.length && candidates[position] == candidates[index]) {
            position++;
        }   
        // Case with element        
        current.add(candidates[index]);
        solve(candidates, target - candidates[index], index + 1, result, current);
        current.remove(current.size() - 1);
        // Case with no element             
        solve(candidates, target, position, result, current);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(candidates, target, 0, result, current);
        return result;
    }
}
