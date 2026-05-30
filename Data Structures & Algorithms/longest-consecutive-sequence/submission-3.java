class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }
        Set<Integer> visited = new HashSet<Integer>();
        int maxLen = 0;
        for(int i=0;i<nums.length;i++) {
            if(visited.contains(nums[i])) {
                continue;
            }
            int m = 1;
            int cnt = 1;
            while(freq.containsKey(nums[i]-m)) {
                //cnt = cnt + freq.get(nums[i]-m);
                cnt++;
                visited.add(nums[i]-m);
                m++;
            }
            m = 1;
            while(freq.containsKey(nums[i]+m)) {
                //cnt = cnt + freq.get(nums[i]+m);
                cnt++;
                visited.add(nums[i]+m);
                m++;
            }
            maxLen = Math.max(maxLen, cnt);
        }
        return Math.max(maxLen, 0);
    }
}
