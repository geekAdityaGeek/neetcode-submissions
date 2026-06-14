class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int prevNode = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= prevNode) {
                prevNode = i;
            }
        }
        return prevNode == 0;
    }
}
