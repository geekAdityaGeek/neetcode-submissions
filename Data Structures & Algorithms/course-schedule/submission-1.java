class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList());
        }
        
        int indegree[] = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        LinkedHashSet<Integer> sorted = new LinkedHashSet(); 
        
        Queue<Integer> Q = new LinkedList();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0) {
                Q.add(i);
                sorted.add(i);
            }
        }

        //System.out.println(sorted);

        while(!Q.isEmpty()) {
            int node = Q.remove();
            for(int child : adj.get(node)) {
                indegree[child]--;
                if(indegree[child] == 0) {
                    Q.add(child);
                    sorted.add(child);
                }
            }
            //System.out.println(sorted);
        }

        return sorted.size() == numCourses;

        
    }
}
