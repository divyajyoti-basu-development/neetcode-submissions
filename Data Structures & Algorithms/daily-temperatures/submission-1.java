class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexStack = new Stack<>();
        int[] result = new int[temperatures.length];
        indexStack.push(0);
        for(int index = 1 ; index < temperatures.length ; index++) {
            while(!indexStack.isEmpty() && temperatures[index] > temperatures[indexStack.peek()]) {
                result[indexStack.peek()] = index - indexStack.peek();
                indexStack.pop();
            }
            indexStack.push(index);
        }
        return result;
    }
}
