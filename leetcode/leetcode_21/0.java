/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current = null;
        ListNode head = null;
        while(l1 != null || l2 != null) {
            ListNode temp;
            int l1_val = Integer.MAX_VALUE;
            int l2_val = Integer.MAX_VALUE;
            if (l1 != null) {
                l1_val = l1.val;
            }
            if (l2 != null) {
                l2_val = l2.val;
            }
            if (l1_val > l2_val) {
                temp = l2;
                l2 = l2.next;
                
            } else {
                temp = l1;
                l1 = l1.next;
            }
            if (current == null) {
                current = temp;
                head = current;
            } else {
                current.next = temp;
                current = current.next;
            }
        }
     return head;   
    }
}