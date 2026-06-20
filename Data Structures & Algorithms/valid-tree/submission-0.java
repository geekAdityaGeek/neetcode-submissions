class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList());
        }
        for(int i=0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> Q = new LinkedList();
        Q.add(0);
        Set<Integer> visited = new HashSet();
        while(!Q.isEmpty()) {
            int node = Q.remove();
            visited.add(node);
            //System.out.println(visited);
            for(int child : adj.get(node)) {
                if(!visited.contains(child)) {
                    Q.add(child);
                }
            }
            //System.out.println("Queue : "+Q);
        }

        return visited.size() == n;
        
    }
}
