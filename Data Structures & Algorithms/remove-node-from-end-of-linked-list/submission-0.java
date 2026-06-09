/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        while (n > 0) {
            ptr = ptr.next;
            n--;
        }
        if (ptr == null) {
            if (n == 0) {
                return head.next;
            } else {
                return head;
            }
        }
        ListNode prevNode = head;
        while (ptr.next != null) {
            ptr = ptr.next;
            prevNode = prevNode.next;
        }
        // System.out.println(prevNode.val);
        prevNode.next = prevNode.next.next;
        return head;
    }
}
