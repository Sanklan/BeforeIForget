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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        ListNode current = head;
        ListNode temp;
        while(current != null) {
            temp = current;
            current = current.next;
            if (newHead == null) {
                newHead = temp;
                newHead.next = null;
            } else {
                temp.next = newHead;
                newHead = temp;
            }
        }

        return newHead;

    }
}