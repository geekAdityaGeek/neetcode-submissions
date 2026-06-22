class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> mapping = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = mapping.getOrDefault(nums[i], new ArrayList());
            list.add(i);
            mapping.put(nums[i], list);
        }
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (mapping.containsKey(m)) {
                List<Integer> list = mapping.get(m);
                int pos = list.get(0);
                if (pos != i) {
                    return new int[] {i, pos};
                } else if (list.size() > 1) {
                    return new int[] {i, list.get(1)};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
