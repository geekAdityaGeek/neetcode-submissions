class Solution {
    private int findParent(int[] parent, int node) {
        if(parent[node] == -1) {
            return node;
        }
        int p = findParent(parent, parent[node]);
        parent[node] = p;
        return p;
    }
    private boolean checkLeastConnected(int[] parent, int[] edge) {

        int parent0 = findParent(parent, edge[0]-1);
        int parent1 = findParent(parent, edge[1]-1);
        if(parent1 == parent0) {
            return false;
        }
        parent[parent0] = parent1;
        return true;

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        for(int i=0 ; i<n;i++) {
            parent[i] = -1;
        }
        for(int i=0;i<edges.length;i++) {
            int edge[] = edges[i];
            if(!checkLeastConnected(parent, edge)) {
                return edge;
            }
        }
        return new int[]{-1, -1};
    }
}
