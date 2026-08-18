class Solution {
    public int search(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                if(target <= nums[right] && nums[mid] <= nums[right]
                    || target >= nums[left] && nums[mid] >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target <= nums[right] && nums[mid] <= nums[right]
                    || target >= nums[left] && nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
