class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[h] < nums[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        int low = 0, high = 0;
        int cut = h;
        if (nums[cut] <= target && target <= nums[nums.length - 1]) {
            low = cut;
            high = nums.length;
        } else {
            low = 0;
            high = cut - 1;
        }

        // System.out.println(low + " : " + high);
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = high - 1;
            }
        }

        return nums[low] == target ? low : -1;
    }
}
