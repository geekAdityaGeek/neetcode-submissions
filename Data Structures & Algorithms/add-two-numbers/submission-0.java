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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ansHead = null;
        ListNode temp1 = l1, temp2 = l2;
        ListNode temp = null;
        while (temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (temp == null) {
                temp = new ListNode(sum);
                ansHead = temp;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            int sum = temp1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            int sum = temp2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            temp2 = temp2.next;
        }

        if (carry == 1) {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }

        return ansHead;
    }
}
