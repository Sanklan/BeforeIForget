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
        ListNode l1r = l1;//reverse(l1);
        ListNode l2r = l2;//reverse(l2);
        ListNode result = null;
        ListNode headR = null;
        //printList(l1r);
        //printList(l2r);
        
        while(l1r != null || l2r != null) {
            int a = (l1r == null) ? 0 : l1r.val;
            int b = (l2r == null) ? 0 : l2r.val;
            ListNode newNode = new ListNode(a + b);
            if (result == null) {
                result = newNode;
                headR = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
            
            l1r = (l1r == null) ? null : l1r.next;
            l2r = (l2r == null) ? null : l2r.next;
          }
        result = headR;
        //printList(result);
        
        ListNode cur = result;
        int carry = 0;
        while(cur != null) {
            int new_val = cur.val + carry;
            carry = 0;
            if (new_val > 9) {
                carry = new_val / 10;
                new_val = new_val % 10;
                
            }
            
            //if next node is null & carry is non zero .. add a node and update carry
            if(carry > 0 && cur.next == null) {
                cur.next = new ListNode(carry);
                carry = 0;
            }
            // update current node value
            cur.val = new_val;
            //move cur to next node
            cur = cur.next;
        }
        
        return result;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    private void printList(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode t = head;
        while(t != null) {
            builder.append( t.val + " ," );
            t = t.next;
        }
        if (builder.length() > 0) {
            System.out.println(builder.toString()); 
        }
    }
}