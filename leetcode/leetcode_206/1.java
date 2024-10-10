/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null, next = null;
        while(current != null) {
           next = current.next;
           current.next = previous;
           previous = current;
           current = next;
        }
        
        return previous;
    }
}