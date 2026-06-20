/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> nodeMapping = new HashMap();
    private void print(List<Node> children) {

        for(Node node : children) {
            System.out.print(node.val);
        }
        System.out.println();

    }
    private Node cloneData(Node node, HashSet<Node> visited) {
        
        if(node == null) {
            return null;
        }

        if(visited.contains(node)) {
            return nodeMapping.get(node);
        }

        Node newNode = new Node(node.val);
        nodeMapping.put(node, newNode);
        visited.add(node);

        for(Node child : node.neighbors) {
            Node newChild = cloneData(child, visited);
            if(newChild != null) {
                newNode.neighbors.add(newChild);
            }
        }

        // System.out.print(node.val);
        // print(node.neighbors);


        return newNode;

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashSet<Node> visited = new HashSet<Node>();
        return cloneData(node, visited);
    }
}