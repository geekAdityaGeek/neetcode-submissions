class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        while(l < h) {
            while(l < h && nums[h] == 2) {
                h--;
            }
            while(l < h && nums[l] != 2) {
                l++;
            }
            if(l < h) {
                int t = nums[l]; 
                nums[l] = nums[h];
                nums[h] = t;
            }
        }

        // for(int k : nums) {
        //     System.out.print(k+" : ");
        // }
        // System.out.println();

        l = 0;
        while(l < h) {
            while(l < h && nums[h] == 1) {
                h--;
            }
            while(l < h && nums[l] != 1) {
                l++;
            }
            if(l < h) {
                int t = nums[l]; 
                nums[l] = nums[h];
                nums[h] = t;
            }
        }

        // for(int k : nums) {
        //     System.out.print(k+" : ");
        // }
        // System.out.println();

    }
}