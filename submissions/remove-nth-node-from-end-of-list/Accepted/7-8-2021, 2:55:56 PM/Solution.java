// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode nth = null;
        ListNode current = dummy;
        
        int count = -1;
        
        while (current != null) {
            count++;
            
            if (nth != null)
                nth = nth.next;
            
            if (count == n) {
                nth = dummy;
            }
            
            current = current.next;
        }
        
        nth.next = nth.next.next;
        
        return dummy.next;
    }
}