class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, left = 0, right = height.length - 1;
        int result = 0;
        while(left <= right) {
            if(leftMax < rightMax) {
                result += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                result += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return result;
    }
}
