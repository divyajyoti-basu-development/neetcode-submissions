class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int currentIndex = 0;
        Set<Integer> indexSet;
        for(int index = 0 ; index < nums.length - 2 ; index++) {            
            if(nums[index] > 0) break;
            if(index != 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            //System.out.println("Index: " + index);
            int left = index + 1;
            int right = nums.length - 1;
            while(left < right) {
                if(left != (index + 1) && nums[left] == nums[left - 1]) {
                    left++;                    
                    continue;
                }
                //System.out.println("Left: " + left);                
                if(nums[left] + nums[right] + nums[index] == 0) {
                    result.add(List.of(nums[index], nums[left], nums[right]));
                    left++;                    
                }
                if(nums[left] + nums[right] < 0 - nums[index]) {
                    left++;
                } else {
                    right--;
                }
            }
        }  
        return result;      
    }
}
