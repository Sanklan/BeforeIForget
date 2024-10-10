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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cursor = head;
        while(cursor != null) {
            stack.push(cursor);
            cursor = cursor.next;
        }

        k = k % stack.size();
        if (k == 0) return head;
        ListNode newHead = null;
        ListNode prev = stack.pop();
        prev.next = head;
        while(k > 0) {
            if (k == 1) {
                newHead = prev;
            }
            prev = stack.pop();
            if (k == 1) prev.next = null;
            k--;
        }
        return newHead;
    }
}