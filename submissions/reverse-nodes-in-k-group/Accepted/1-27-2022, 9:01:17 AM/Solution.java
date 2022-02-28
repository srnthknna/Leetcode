// https://leetcode.com/problems/reverse-nodes-in-k-group

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
        ListNode dummy = new ListNode(-1, head), prev = dummy, tail = dummy;
        
        do {
            tail = findKthNode(prev, k);
            if (tail != null) {
                //reverse between tail and head
                ListNode next = tail.next;
                prev.next = reverse(head, next);
                prev = head;
                head.next = next;
                head = next;
                
            }
        } while (tail != null);
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null, next;
        while (head != tail) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    private ListNode findKthNode(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k && tail != null; i++) {
            tail = tail.next;
        }
        return tail;
    }
}