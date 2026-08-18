class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        int result = 0, currentIndex;        
        for(int index = 0 ; index < heights.length ; index++) {
            if(indexStack.size() == 1) {
                indexStack.push(index);
            } else {
                while(indexStack.size() > 1 && heights[indexStack.peek()] > heights[index]) {
                    currentIndex = indexStack.pop();
                    result = Math.max(heights[currentIndex] * (index - indexStack.peek() - 1), result);
                }
                indexStack.push(index);
            }
        }                
        while(indexStack.size() > 1) {
            currentIndex = indexStack.pop();
            result = Math.max(heights[currentIndex] * (heights.length - indexStack.peek() - 1), result);
        }        
        return result;
    }
}
