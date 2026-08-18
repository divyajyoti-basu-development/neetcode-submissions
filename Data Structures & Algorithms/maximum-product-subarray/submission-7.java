class Solution {
    Integer[] maxMemo;
    Integer[] minMemo;
    int[] nums;

    public int maxProduct(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        maxMemo = new Integer[n];
        minMemo = new Integer[n];

        int ans = nums[0];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, maxProd(i));
        }
        return ans;
    }

    private int maxProd(int i) {
        if (maxMemo[i] != null) return maxMemo[i];
        if (i == 0) return maxMemo[i] = nums[0];

        int prevMax = maxProd(i - 1);
        int prevMin = minProd(i - 1);

        return maxMemo[i] = Math.max(
            nums[i],
            Math.max(nums[i] * prevMax, nums[i] * prevMin)
        );
    }

    private int minProd(int i) {
        if (minMemo[i] != null) return minMemo[i];
        if (i == 0) return minMemo[i] = nums[0];

        int prevMax = maxProd(i - 1);
        int prevMin = minProd(i - 1);

        return minMemo[i] = Math.min(
            nums[i],
            Math.min(nums[i] * prevMax, nums[i] * prevMin)
        );
    }
}
