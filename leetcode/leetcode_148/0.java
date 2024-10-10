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
    public ListNode sortList(ListNode head) {
        //size(head);
        if (head == null || head.next == null) 
            return head;
        
        ListNode mid = mid(head);
        ListNode second = mid.next;
        mid.next = null;
        //size(head);
        head = sortList(head);
        second = sortList(second);
       // System.out.println("merging " + head.val + " " + second.val);
      //  size(head);
      //  size(second);
        return mergeSorted(head, second);

    }

    void size(ListNode head) {
        int count = 0;
        while(head != null) {
            count++; head = head.next;
        }
        System.out.println(count);
    }
    void print(ListNode head) {
        int count = 0;
        String s = "";
        while(head != null) {
            s = s + " -> " + head.val;
            count++; head = head.next;
        }
        System.out.println(s);
    }

    ListNode mergeSorted(ListNode one, ListNode two) {
        /*System.out.println("one - two");
        size(one);
        size(two);
        System.out.println("loop");*/
        ListNode head = null, tail = null;
        while(one != null || two != null) {
            
            if (one == null) {
                tail.next = two;
                tail = tail.next;
                two = two.next;
            } 
            else if (two == null) {
                tail.next = one;
                tail = tail.next;
                one = one.next;
            } 
            else if (one.val <= two.val) {
                if (head == null) {
                    head = one;
                    tail = one;
                }
                else {
                    tail.next = one;
                    tail = tail.next;
                }
                one = one.next;

            } 
            else {
                 if (head == null) {
                    head = two;
                    tail = two;
                }
                else {
                    tail.next = two;
                    tail = tail.next;
                }
                
                two = two.next;

            }

           // print(head);
        }
        
        return head;
    }

    private ListNode mid(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode ret = null;
        while(fast != null && fast.next != null) {
            ret = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return ret;
    }
}