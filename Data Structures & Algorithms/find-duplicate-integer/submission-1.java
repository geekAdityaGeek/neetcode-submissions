class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] < 0) {
                return pos + 1;
            }
            nums[pos] = -1 * nums[pos];
        }
        return -1;
    }
}
