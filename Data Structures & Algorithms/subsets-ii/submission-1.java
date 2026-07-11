class Solution {
    List<List<Integer>> ans = new ArrayList();
    private void compute(int nums[], int pos, Stack<Integer> res) {

        if(pos >= nums.length) {
            ans.add(new ArrayList<Integer>(res));
            return;
        }

        ans.add(new ArrayList<Integer>(res));

        for(int i = pos ; i<nums.length;i++) {
            if(i > pos && nums[i] == nums[i-1]) {
                continue;
            }
            res.push(nums[i]);
            compute(nums, i+1, res);
            res.pop();
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        compute(nums, 0, new Stack<Integer>());
        return ans;
    }
}
