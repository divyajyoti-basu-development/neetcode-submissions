class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for(int index = 0 ; index < nums.length ; index++) {
            if(numIndexMap.containsKey(target - nums[index])) {
                return new int[] {numIndexMap.get(target - nums[index]), index};
            }
            numIndexMap.put(nums[index], index);
        }
        return new int[] {};
    }
}
