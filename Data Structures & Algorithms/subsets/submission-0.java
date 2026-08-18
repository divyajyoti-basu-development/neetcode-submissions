class Solution {

    private List<List<Integer>> recursiveSubSetsFind(int[] nums, int index) {
        if(index == nums.length) {
            return new ArrayList<>() {
                { add(new ArrayList<>());}
            };
        }
        List<List<Integer>> combinationsWithout = recursiveSubSetsFind(nums, index + 1);
        List<List<Integer>> combinationsWith = new ArrayList<>();
        combinationsWithout.forEach(list -> {
            list = new ArrayList<>(list);
            list.add(nums[index]);
            combinationsWith.add(list);
    });
        List<List<Integer>> result = new ArrayList<>(combinationsWithout);
        result.addAll(combinationsWith);
        return result;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return recursiveSubSetsFind(nums, 0);
    }
}
