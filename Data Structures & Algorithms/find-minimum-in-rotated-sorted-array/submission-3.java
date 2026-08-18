class Solution {
    public int findMin(int[] nums) {
       int left = 0, right = nums.length - 1, mid;
       while(left <= right) {
            mid = (left + right) / 2;
            if(nums[left] <= nums[mid] && nums[right] >= nums[mid]) {
                return nums[left];            
            }
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
            right = mid;
            }
       }
       return Integer.MAX_VALUE; 
    }
}