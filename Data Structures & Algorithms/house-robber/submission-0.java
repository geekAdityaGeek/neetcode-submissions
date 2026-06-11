class Solution {
    int dp[];
    private int compute(int nums[], int pos) {
        if (pos >= nums.length) {
            return 0;
        }
        if (dp[pos] != -1) {
            return dp[pos];
        }
        dp[pos] = Math.max(compute(nums, pos + 1), compute(nums, pos + 2) + nums[pos]);
        return dp[pos];
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return nums.length == 1 ? nums[0] : Math.max(compute(nums, 0), compute(nums, 1));
    }
}
