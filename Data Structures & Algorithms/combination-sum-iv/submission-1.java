class Solution {
    int dp[];
    private int count(int nums[], int target) {
        if(target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        }
        if(dp[target] != -1) {
            return dp[target];
        }
        int cnt = 0 ; 
        for(int n : nums) {
            cnt = cnt + count(nums, target-n);
        }
        dp[target] = cnt;
        return cnt;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        for(int i = 0 ; i<=target ; i++) {
            dp[i] = -1;
        }
        return count(nums, target);
    }
}