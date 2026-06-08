class Solution {

    List<List<Integer>> ans = new ArrayList();
    private void compute(int[] nums, int target, int pos, List<Integer> res) {
        if(target == 0) {
            List<Integer> sol = new ArrayList();
            sol.addAll(res);
            ans.add(sol);
            return;
        } else if( target < 0 || pos >= nums.length) {
            return;
        }
        compute(nums, target, pos+1, res);
        res.add(nums[pos]);
        compute(nums, target - nums[pos], pos, res);
        res.remove(res.size() - 1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        compute(nums, target, 0, new ArrayList<Integer>());
        return ans;
        
    }
}