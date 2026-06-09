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
    private void printLL(ListNode node) {
        ListNode temp = node;
        System.out.print("List Node : ");
        while (temp != null) {
            System.out.print(temp.val + " : ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void reorderList(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (fastPtr != null) {
                fastPtr = fastPtr.next;
            }
        }

        ListNode head1 = head;
        ListNode head2 = slowPtr.next;
        slowPtr.next = null;

        ListNode prev = null;
        ListNode temp = head2;
        while (temp != null) {
            ListNode nextTemp = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextTemp;
        }
        head2 = prev;

        // printLL(head1);
        // printLL(head2);
        ListNode temp2 = head2;
        ListNode temp1 = head1;
        while (temp2 != null) {
            ListNode nextTemp1 = temp1.next;
            ListNode nextTemp2 = temp2.next;
            temp1.next = temp2;
            temp2.next = nextTemp1;
            temp1 = nextTemp1;
            temp2 = nextTemp2;
        }
    }
}
