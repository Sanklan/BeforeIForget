/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode RemoveElements(ListNode head, int val) {
        ListNode current = head;
        ListNode previous = null;
        while(current != null)
        {
            if(current.val == val)
            {
                if(previous == null)
                {
                    current = current.next;
                    head = head.next;
                   
                }
                else 
                {
                        previous.next = current.next;
                        current = current.next;
                        
                }
                 continue;
            }
            previous = current;
            current = current.next;
        }
        
        return head;
        
    }
}