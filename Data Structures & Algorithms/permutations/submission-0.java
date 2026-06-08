class Solution {
    List<List<Integer>> ans = new ArrayList();
    private void compute(Set<Integer> pending, List<Integer> res) {
        if(pending.size() == 0) {
            ans.add(new ArrayList(res));
        }
        for(int n : pending) {
            res.add(n);
            Set<Integer> updatedPending = new HashSet(pending);
            updatedPending.remove(n);
            compute(updatedPending, res);
            res.remove(res.size()-1);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> pending = new HashSet();
        for(int n : nums) {
            pending.add(n);
        }
        compute(pending, new ArrayList());
        return ans;
        
    }
}
