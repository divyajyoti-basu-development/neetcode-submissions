class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target, left, right;
        List<List<Integer>> result = new ArrayList<>();
        for(int index = 0 ; index < nums.length - 2 ; index++) {
            if(nums[index] > 0) {
                return result;
            }
            if(index != 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            target = -nums[index];
            left = index + 1;
            right = nums.length - 1;
            while(left < right) {
                if(left != index + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if(nums[left] + nums[right] < target) {
                    left++;
                } else if(nums[left] + nums[right] > target) {
                    right--;
                } else {
                    result.add(List.of(nums[index], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
