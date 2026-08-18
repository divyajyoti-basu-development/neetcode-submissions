class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, max = 0;
        while(left < right) {
            max = Math.max(max, Math.min(heights[left], heights[right]) * (right - left));
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
