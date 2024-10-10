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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode newHead = null, tail = null;
        while(current != null && current.next != null) {
            ListNode one = current;
            ListNode two = current.next;
            current = current.next.next;

            if (tail == null) {
                newHead = two;
            } else {
                tail.next = two;
            }

            one.next = current;
            two.next = one;
            tail = one;
        }

        return newHead;
        /*ListNode newHead = head.next;
        ListNode current = newHead.next;
        newHead.next = head;
        head.next = current;
        ListNode prev = head;
        while(current != null) {
            if (current.next != null) {
                prev.next = current.next;
                current.next = current.next.next;
                prev = prev.next;
                prev.next = current;


            }
        }
        
        return newHead;*/
    }
}