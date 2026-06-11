class Solution {
    int dp[];
    private int compute(int nums[], int pos, int limit) {
        if (pos >= limit) {
            return 0;
        }

        if (dp[pos] != -1) {
            return dp[pos];
        }
        dp[pos] =
            Math.max(compute(nums, pos + 1, limit), nums[pos] + compute(nums, pos + 2, limit));
        return dp[pos];
    }
    private void initDP() {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
    }
    private void print() {
        for (int n : dp) {
            System.out.print(n + " : ");
        }
        System.out.println();
    }
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        dp = new int[nums.length];
        initDP();
        int max1 = compute(nums, 0, dp.length - 1);
        initDP();
        int max2 = compute(nums, 1, dp.length);
        return Math.max(max1, max2);
    }
}
