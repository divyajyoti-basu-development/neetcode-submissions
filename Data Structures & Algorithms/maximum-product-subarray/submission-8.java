class Solution {

    Integer[] maxProductMemo;
    Integer[] minProductMemo;

    private int maxProductDp(int[] nums, int index) {
        if(index == nums.length - 1) {
            return nums[index];
        }
        if(maxProductMemo[index] != null) {
            return maxProductMemo[index];
        }
        int subArrMaxProduct = maxProductDp(nums, index + 1);
        int subArrMinProduct = minProduct(nums, index + 1);
        int maxProduct = Math.max(nums[index], Math.max(subArrMaxProduct * nums[index], subArrMinProduct * nums[index]));
        return maxProductMemo[index] = maxProduct;
    }

    private int minProduct(int[] nums, int index) {
        if(index == nums.length - 1) {
            return nums[index];
        }
        if(minProductMemo[index] != null) {
            return minProductMemo[index];
        }
        int subArrMaxProduct = maxProductDp(nums, index + 1);
        int subArrMinProduct = minProduct(nums, index + 1);
        int minProduct = Math.min(nums[index], Math.min(subArrMaxProduct * nums[index], subArrMinProduct * nums[index]));
        return minProductMemo[index] = minProduct;
    }    

    public int maxProduct(int[] nums) {
        maxProductMemo = new Integer[nums.length];
        minProductMemo = new Integer[nums.length];
        int result = nums[0];
        for(int index = 0 ; index < nums.length ; index++) {
            result = Math.max(result, maxProductDp(nums, index));
        }
        return result;
    }
}
