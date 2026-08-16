class Solution {
    private void reverse (int nums[] , int start, int end) {
        while(start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++; end--;
        }
        return ;
    }
    private void print(int nums[]) {
        for(int n : nums) {
            System.out.print(n+" : ");
        }
        System.out.println();
    }
    public void rotate(int[] nums, int k) {

        k = k%nums.length;
        
        reverse(nums, 0, nums.length-1);
        //print(nums);
        reverse(nums, 0, k-1);
        //print(nums);
        reverse(nums, k, nums.length-1);
        //print(nums);
    }
}