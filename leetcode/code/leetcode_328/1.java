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
        if (head == null) return head;
        
        ListNode tailOdd = head;
        ListNode headEven = head.next;
        ListNode tailEven = head.next;
        
        if (headEven == null) return head;
        
        ListNode current = head.next.next;
        tailEven.next = null;
        boolean odd = true;
        while (current != null) {
            ListNode temp = current.next;
            if (odd) {
                tailOdd.next = current;
                tailOdd = current;
                tailOdd.next = headEven;
            } else {
                tailEven.next = current;
                tailEven = current;
                tailEven.next = null;
            }            
            odd = (odd) ? false:true;
            current = temp;
        }
        return head;
    }
}