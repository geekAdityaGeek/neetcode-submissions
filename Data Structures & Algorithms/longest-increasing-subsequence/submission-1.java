class Solution {
    int dp[][];
    private int compute(int nums[], int pos, int prev) {
        if (pos >= nums.length) {
            return 0;
        }
        if (dp[pos][prev + 1] != -1) {
            return dp[pos][prev + 1];
        }
        int len = 0;
        len = Math.max(len, compute(nums, pos + 1, prev));
        if (prev == -1 || nums[pos] > nums[prev]) {
            len = Math.max(len, compute(nums, pos + 1, pos) + 1);
        }
        dp[pos][prev + 1] = len;
        return len;
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return compute(nums, 0, -1);
    }
}
