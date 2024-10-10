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
    public int pairSum(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = head;
        while(current != null) {
            stack.push(current);
            current = current.next;
        }
        int max = Integer.MIN_VALUE;
        current = head;
        while(!stack.isEmpty()) {
            max = Math.max(max, current.val + stack.pop().val);
            current = current.next;
        }

        return max;
    }
}