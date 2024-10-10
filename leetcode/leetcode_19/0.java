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
        //Stack<ListNode> stack = new Stack<ListNode>();
        int len = 0;
        ListNode cursor = head;
        while(cursor != null) {
            len++;
            cursor = cursor.next;
        }

        int del = len - n;
        ListNode prev = null;
        cursor = head;
        
        while(del > 0) {
            prev = cursor;
            cursor = cursor.next;
            del--;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = cursor.next;
        }

        return head;
    }
}