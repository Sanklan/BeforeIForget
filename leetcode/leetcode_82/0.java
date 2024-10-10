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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode parent = null;
        ListNode current = head;
        int count;

        while(current != null) {
            count = 0;
            ListNode tmp = current;
            while(tmp != null && tmp.val == current.val) {
                tmp = tmp.next;
                count++;
            }

            if (count > 1) {
                // if parent is null
                if (parent != null)
                    parent.next = tmp;
                else 
                    head = tmp;

            } else {
                parent = current;
            }
            current = tmp;
        }

        return head;
    }
}