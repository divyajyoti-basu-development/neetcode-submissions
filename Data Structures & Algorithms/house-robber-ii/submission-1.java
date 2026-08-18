class Solution {
    
    private int[] memo;

    private int getMaxMoney(int[] nums, int houseNo, int limit) {
        //System.out.println("HouseNo: " + houseNo + " limit: " + limit);
        if(houseNo > limit) {
            return 0;
        }
        if(memo[houseNo] != -1) {
            return memo[houseNo];
        }
        memo[houseNo] = Math.max(nums[houseNo] + getMaxMoney(nums, houseNo + 2, limit), getMaxMoney(nums, houseNo + 1, limit));
        //System.out.println("HouseNo: " + houseNo + " Max Money: " + memo[houseNo]);
        return memo[houseNo];
    }
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        //System.out.println("Start from houseNo 0");
        int money1 = getMaxMoney(nums, 0, nums.length - 2);
        Arrays.fill(memo, -1);
        //System.out.println("Start from houseNo 1");
        int money2 = getMaxMoney(nums, 1, nums.length - 1);
        return Math.max(money1, money2);
    }
}