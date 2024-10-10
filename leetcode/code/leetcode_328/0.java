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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode tail = even;
        while((odd.next != null && odd.next.next != null) || (even.next != null && even.next.next != null)) {
            if (odd.next.next != null) {
                odd.next = odd.next.next;
                odd = odd.next;
            }
            if (even.next.next != null) {
                even.next = even.next.next;
                even = even.next;
            }
        }
        even.next = null;
        odd.next = tail;
        return head;
    }
}