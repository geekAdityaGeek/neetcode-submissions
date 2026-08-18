class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum  = 0;
        int h = 0;
        while( h < nums.length && sum+nums[h] < target) {
            sum = sum + nums[h];
            h++;
        }
        int len = nums.length + 1;
        while(h < nums.length) {
            sum = sum + nums[h];
            while(sum >= target) {
                len = Math.min(len, h-l+1);
                sum = sum - nums[l];
                l++;
            }
            h++;
        }
        return len == nums.length+1 ? 0 : len ;
    }
}