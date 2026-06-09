/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> newNodeMapping = new HashMap();
        Node temp = head;
        Node temp1 = null;
        Node head2 = null;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            if(temp1 == null) {
                temp1 = newNode;
                head2 = newNode;
            } else {
                temp1.next = newNode;
                temp1 = temp1.next;
            }
            newNodeMapping.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            Node newNode = newNodeMapping.get(temp);
            Node newRandomNode = newNodeMapping.get(temp.random);
            newNode.random = newRandomNode;
            temp = temp.next;
        }

        return head2;
    }
}
