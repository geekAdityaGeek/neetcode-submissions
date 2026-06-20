class Solution {

    private void dfs(List<List<Integer>> adj, int node, HashSet<Integer> visited) {
        if(visited.contains(node)) {
            return;
        }
        visited.add(node);
        for(int child : adj.get(node)) {
            dfs(adj, child, visited);
        }
    }
    public int countComponents(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList());
        }
        for(int i=0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visited = new HashSet();

        int component = 0;
        for(int i=0;i<n;i++) {
            if(visited.contains(i)) {
                continue;
            }
            component++;
            dfs(adj, i, visited);
        }

        return component;

    }
}
