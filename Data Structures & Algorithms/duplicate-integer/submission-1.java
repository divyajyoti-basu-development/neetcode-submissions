class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for(int element : nums) {
            if(uniqueSet.contains(element)) {
                return true;
            }
            uniqueSet.add(element);
        }
        return false;
    }
}