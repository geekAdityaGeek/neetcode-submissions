class Solution {
    List<List<Integer>> ans = new ArrayList();
    private void compute(int nums[], int pos) {
        if (pos >= nums.length) {
            return;
        }

        int len = ans.size();
        for (int i = 0; i < len; i++) {
            List<Integer> dup = new ArrayList();
            dup.addAll(ans.get(i));
            dup.add(nums[pos]);
            ans.add(dup);
        }
        //System.out.println(ans);
        compute(nums, pos + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList());
        compute(nums, 0);
        return ans;
    }
}
