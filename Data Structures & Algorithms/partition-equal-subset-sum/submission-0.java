class Solution {
    int dp[][];
    private boolean compute(int[] nums, int pos, int currSum, int totSum) {
        if (2 * currSum == totSum) {
            return true;
        }

        if (pos >= nums.length) {
            return false;
        }

        if (dp[pos][currSum] != -1) {
            return dp[pos][currSum] == 0 ? false : true;
        }

        boolean ans = compute(nums, pos + 1, currSum + nums[pos], totSum)
            || compute(nums, pos + 1, currSum, totSum);

        dp[pos][currSum] = ans ? 1 : 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s = s + nums[i];
        }
        dp = new int[nums.length][s + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] = -1;
            }
        }
        return compute(nums, 0, 0, s);
    }
}
