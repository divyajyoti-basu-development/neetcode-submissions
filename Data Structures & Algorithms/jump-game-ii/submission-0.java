class Solution {
    public int jump(int[] nums) {
        int l, r;
        l = r = 0;
        int steps = 0;
        int farthest = 0;
        while(r < nums.length - 1) {
            while(l <= r) {
                farthest = Math.max(farthest, l + nums[l]);
                l++;
            }
            steps++;
            r = farthest;
        }
        return steps;
    }
}