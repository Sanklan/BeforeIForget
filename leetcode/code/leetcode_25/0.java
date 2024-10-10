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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k);
    }

    private ListNode reverse(ListNode head, int k) {
        if (head == null) return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        int l = k;
        ListNode current = head;
        while(l > 0 && current != null) {
            stack.add(current);
            current = current.next;
            l--;
        }
        if (l > 0) return head;
        ListNode next = reverse(current, k);

        ListNode newHead = stack.pop();
        current = newHead;
        while(!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        current.next = next;

        return newHead;
    }
}