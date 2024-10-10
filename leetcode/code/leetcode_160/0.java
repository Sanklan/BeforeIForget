/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> a = new Stack<ListNode>();
        Stack<ListNode> b = new Stack<ListNode>();
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null) {
            a.push(curA);
            curA = curA.next;
        }
        
        while(curB != null) {
            b.push(curB);
            curB = curB.next;
        }
        
        if (headA == null || headB == null) return null;
        
        ListNode result = null;
        curA = a.pop();
        curB = b.pop();
        while(curA == curB) {
            result = curA;
            if(a.empty() || b.empty()) break;
            curA = a.pop();
            curB = b.pop();
        }
        
        return result;
    }
}