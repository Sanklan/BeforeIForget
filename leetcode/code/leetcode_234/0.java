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
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(current != null) {
            stack.push(current);
            current = current.next;
        }
        
        current = head;
        while(current != null) {
            if (current.val != stack.pop().val) return false;
            current = current.next;
        }
        
        return true;
    }
}