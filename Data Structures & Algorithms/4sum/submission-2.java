class Solution {
    private List<List<Integer>> find(int[] nums, int start, long target) {
        List<List<Integer>> ans = new ArrayList();
        int l = start , h = nums.length-1;
        while(l < h) {
            if(l > start && nums[l] == nums[l-1]) {
                l++;
                continue;
            }
            if(nums[l] + nums[h] == target) {
                List<Integer> res = new ArrayList();
                res.add(nums[l]);
                res.add(nums[h]);
                ans.add(res);
                l++;
                h--;
            } else if(nums[l]+nums[h] < target ) {
                l++;
            } else {
                h--;
            }
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                List<List<Integer>> res = find(nums, j + 1, ((long)target) - nums[i] - nums[j]);
                //System.out.println(target - nums[i] - nums[j] + " : " + res);
                for(List<Integer> pos : res) {
                    pos.add(nums[i]);
                    pos.add(nums[j]);
                    ans.add(pos);
                }
            }
        }
        return ans;
    }
}
