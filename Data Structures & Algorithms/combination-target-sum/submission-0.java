class Solution {

    private List<List<Integer>> recursiveTargetFind(int[] nums, int target, int index) {
        if(target == 0) {
            return new ArrayList<>() {
                { add(new ArrayList<>()); }
            };            
        }
        if(target < 0 || index == nums.length) {
            return new ArrayList<>();
        }
        List<List<Integer>> combinationsWith = recursiveTargetFind(nums, target - nums[index], index);
        combinationsWith.forEach(list -> list.add(nums[index]));
        List<List<Integer>> combinationsWithout = recursiveTargetFind(nums, target, index + 1);
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(combinationsWith);
        result.addAll(combinationsWithout);
        return result;
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return recursiveTargetFind(nums, target, 0);
    }
}
