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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null ) return null;
        Stack<ListNode> queue = new Stack<ListNode>();
        ListNode current = head;
        while(current != null) {
            queue.push(current); 
            current = current.next;
        }   
        int size = queue.size();
        if (size % 2 == 0) size--;
        ListNode next = null;
        for(int i = 0; i < size/2; i++) {
            next = queue.pop();
        }
        if (!queue.isEmpty()) queue.pop();
        if (!queue.isEmpty()) queue.peek().next = next;
        return head;
    }

}