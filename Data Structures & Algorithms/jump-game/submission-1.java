class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> Q = new LinkedList();
        Q.add(0);
        Set<Integer> visited = new HashSet();
        while (!Q.isEmpty()) {
            int len = Q.size();
            while (len > 0) {
                int node = Q.remove();
                visited.add(node);
                if (node == nums.length - 1) {
                    return true;
                }
                int c = 1;
                while (node + c < nums.length && c <= nums[node]) {
                    if (visited.contains(node + c)) {
                        c++;
                        continue;
                    }
                    Q.add(node + c);
                    c++;
                }
                //System.out.println(Q);
                len--;
            }
        }
        return false;
    }
}
