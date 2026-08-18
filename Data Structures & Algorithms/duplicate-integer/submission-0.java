class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> countSet = new HashSet<>();
        for(int number : nums) {
            if(countSet.contains(number)) {
                return true;
            }
            countSet.add(number);
        }
        return false;
    }
}