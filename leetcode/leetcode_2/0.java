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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = null;
        ListNode answerHead = null;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null) {
            sum = 0;
            
            if (l1 != null && l2 != null) sum = l1.val + l2.val + carry;
            else if (l1 != null) sum = l1.val + carry;
            else sum = l2.val + carry;
            
            ListNode node = new ListNode();
            
            if (answer == null)  answerHead = node;
            else answer.next = node;
            
            answer = node;
            node.val = sum % 10;
            carry = sum / 10;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) {
            answer.next = new ListNode(carry);
        }

        return answerHead;
    }
}