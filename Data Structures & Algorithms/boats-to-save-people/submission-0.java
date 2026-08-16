class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        if(nums[nums.length-1] > limit) {
            throw new RuntimeException("Not possible");
        }
        int l = 0;
        int h = nums.length-1;
        int cnt = 0;
        while(l <= h) {
            if(nums[l] + nums[h] > limit) {
                cnt++;
                h--;
            } else {
                cnt++;
                l++;h--;
            }
        }
        return cnt;
    }
}