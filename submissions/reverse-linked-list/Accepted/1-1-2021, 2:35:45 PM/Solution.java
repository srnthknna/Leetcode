// https://leetcode.com/problems/reverse-linked-list

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
    public ListNode reverseList(ListNode head) {
        //return reverseHelper(head, null);
        
        ListNode prev = null;
        
        while (head !=  null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
    
    private ListNode reverseHelper(ListNode current, ListNode next) {
        if (current == null) return next;
        ListNode parent = current.next;
        current.next = next;
        return reverseHelper(parent, current);
    }
}