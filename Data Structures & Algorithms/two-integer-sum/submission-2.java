class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int index = 0 ; index < nums.length ; index++) {
            if(indexMap.containsKey(target - nums[index])) {
                return new int[] { indexMap.get(target - nums[index]) , index };
            }
            indexMap.put(nums[index], index);
        }
        return new int[]{};
    }
}
