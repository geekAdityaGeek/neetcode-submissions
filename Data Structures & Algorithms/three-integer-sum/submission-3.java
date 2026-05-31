class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<nums.length-2;i++) {
            if(i!=0 && nums[i] == nums[i-1]) { // ensures that no nums[i] is repeated
                continue;
            }
            int j=i+1, k=nums.length-1;
            while(j<k) {
                if(nums[j]+nums[k] == -1*nums[i]) {
                    List<Integer> res = new ArrayList();
                    res.add(nums[i]);res.add(nums[j]);res.add(nums[k]);
                    ans.add(res);
                    j++;k--;
                    // following 2 conditions suggest that both j and k are not repeated
                    while(j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(j<k && nums[k] == nums[k+1]){
                        k--;
                    }
                } else if (nums[j]+nums[k] < -1*nums[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
