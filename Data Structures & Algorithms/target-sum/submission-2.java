class Solution {
    private int dp[][];
    private int compute(int nums[], int pos, int target) {
        if (pos > nums.length) {
            return 0;
        }
        if (pos == nums.length) {
            if (target == 0)
                return 1;
            else
                return 0;
        }
        if (dp[pos][target+1000] != -1) {
            return dp[pos][target+1000];
        }
        dp[pos][target+1000] =
            compute(nums, pos + 1, target + nums[pos]) + compute(nums, pos + 1, target - nums[pos]);
        return dp[pos][target+1000];
    }

    public int findTargetSumWays(int[] nums, int target) {
        
        dp = new int[nums.length][2001];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= 2000; j++) {
                dp[i][j] = -1;
            }
        }
        return compute(nums, 0, target);
    }
}
