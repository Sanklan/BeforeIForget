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
        int length = 0;
        ListNode cursor = head;
        ListNode tail = null;
        while(cursor != null) {
            length++;
            tail = cursor;
            cursor = cursor.next;
        }
        if (length == 0) return null;
        k = k % length;
        if (k == 0) return head;
        tail.next = head;
        cursor = head;
        ListNode prev = null;
        for ( int i = length - k; i > 0; i--) {
            prev = cursor;
            cursor = cursor.next;
        }

        prev.next = null;
        return cursor;


       /* if (head == null || head.next == null) return head;
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
        return newHead;*/
    }
}