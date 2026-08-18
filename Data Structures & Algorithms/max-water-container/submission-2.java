class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int result = 0;
        while(left < right) {
            result = Math.max(result, (right - left) * Math.min(heights[left], heights[right]));
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
