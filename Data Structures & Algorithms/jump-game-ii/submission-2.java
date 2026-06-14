class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int cnt = 0;
        int currNode = 0;
        int n = nums.length;
        while (currNode + nums[currNode] < n - 1) {
            int r = Math.min(n - 1, currNode + nums[currNode]);
            int l = currNode + 1;
            int maxNode = -1;
            while (l <= r) {
                if (maxNode < l + nums[l]) {
                    currNode = l;
                    maxNode = l + nums[l];
                }
                l++;
                // System.out.println(l);
            }
            // System.out.println(currNode);
            cnt++;
        }
        return cnt + 1;
    }
}
