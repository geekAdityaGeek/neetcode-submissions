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
    private ListNode mergeList(ListNode node1, ListNode node2) {
        ListNode t1 = node1, t2 = node2, t1Prev = t1;
        if (t1.val > t2.val) {
            ListNode insertNode = t2;
            t2 = t2.next;
            insertNode.next = t1;
            t1Prev = insertNode;
            node1 = insertNode;
        }
        while (t1 != null && t2 != null) {
            if (t1.val > t2.val) {
                ListNode insertNode = t2;
                t2 = t2.next;
                t1Prev.next = insertNode;
                insertNode.next = t1;
                t1Prev = t1Prev.next;
            } else {
                t1Prev = t1;
                t1 = t1.next;
            }
        }
        if (t1 == null) {
            t1Prev.next = t2;
        }
        return node1;
    }
    private void print(ListNode node) {
        ListNode t = node;
        while (t != null) {
            System.out.print(t.val + " : ");
            t = t.next;
        }
        System.out.println();
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode masterList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode list = lists[i];
            masterList = mergeList(masterList, list);
            //print(masterList);
        }
        return masterList;
    }
}
