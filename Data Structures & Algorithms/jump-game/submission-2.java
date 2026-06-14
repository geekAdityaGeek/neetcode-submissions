class Solution {
    public boolean canJump(int[] nums) {
        int prevNode = nums.length-1;
        for(int i=nums.length-2;i>=0;i--) {
            if(nums[i]+i >= prevNode) {
                prevNode = i;
            }
        }
        return prevNode == 0;
    }
}
