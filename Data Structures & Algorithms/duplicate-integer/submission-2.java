class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> checkSet = new HashSet<>();
        for(int num : nums) {
            if(checkSet.contains(num)) {
                return true;
            }
            checkSet.add(num);            
        }
        return false;
    }
}