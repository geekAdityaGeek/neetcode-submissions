class Solution {
    public void merge(int nums[], int l , int mid, int h) {
        int i = l; 
        int j = mid+1;
        int k = l;
        int temp[] = new int[nums.length];
        while(i <= mid && j <= h ) {
            if(nums[i] < nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while( i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }
        while(j <= h) {
            temp[k] = nums[j];
            k++;
            j++;
        }
        k = l;
        while(k <= h) {
            nums[k] = temp[k];
            k++;
        }
        return;
    }
    public void sort(int[] nums, int l, int h) {
        if(l < h) {
            int mid = (l+h)/2;
            sort(nums, l, mid);
            sort(nums, mid+1, h);
            merge(nums, l, mid, h);
        }
    }
    public int[] sortArray(int[] nums) {

        sort(nums, 0, nums.length-1);
        return nums;
        
    }
}