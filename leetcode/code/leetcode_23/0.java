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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if (lists.length == 0) return result;
        if (lists.length == 1) return lists[0];
        
        
        Queue<ListNode> minheap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return (n1.val - n2.val);
            }
        });
        
        for(int i = 0; i < lists.length; i++) 
        {
            if (lists[i] != null) {
                minheap.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        
        ListNode index = minheap.poll();
        ListNode current = null;
        while(index != null) {
            if (result  == null) {
                result = index;
                current = index;
            } else {
                current.next = index;
                current = index;
            }
            if (index.next != null) {
                minheap.add(index.next);
            }
            index = minheap.poll();            
        }
        return result;
    }
}