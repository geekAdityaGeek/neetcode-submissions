class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxProd = maxProd * nums[i];
            minProd = minProd * nums[i];
            int t = Math.max(nums[i], Math.max(maxProd, minProd));
            minProd = Math.min(nums[i], Math.min(maxProd, minProd));
            maxProd = t;
            max = Math.max(maxProd, max);
        }
        return max;
    }
}
