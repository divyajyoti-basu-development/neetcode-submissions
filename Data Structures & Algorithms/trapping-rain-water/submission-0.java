class Solution {
    public int trap(int[] heights) {
        int leftMax = 0, rightMax = 0, totalRain = 0, left = 0, right = heights.length - 1;
        while(left <= right) {
            if(leftMax < rightMax) {
                totalRain += Math.max(leftMax - heights[left], 0);
                leftMax = Math.max(leftMax, heights[left]);
                left++;
            } else {
                totalRain += Math.max(rightMax - heights[right], 0);
                rightMax = Math.max(rightMax, heights[right]);
                right--;
            }
        }
        return totalRain;
    }
}
