class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        
        List<List<Integer>> adj = new ArrayList();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> Q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                Q.add(i);
            }
        }

        int pos = 0;
        while (!Q.isEmpty()) {
            int ele = Q.remove();
            ans[pos] = ele;
            pos++;
            for (int next : adj.get(ele)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    Q.add(next);
                }
            }
        }

        if (pos != numCourses) {
            return new int[0];
        }
        return ans;
    }
}
