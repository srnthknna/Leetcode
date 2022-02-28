// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

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
        ListNode headC = head;
        int len = 0;
        while (headC != null) {
            headC = headC.next;
            len++;
        }
        
        if (len == 0 || len == 1) {
            return null;
        } else if (len == 2) {
            head.next = null;
            return head;
        }
        
        int mid = len / 2;
        headC = head;
        
        for (int i = 0; i < mid; i++) {
            headC = headC.next;
        }
        
        delete(headC);
        
        return head;
    }
    
    private void delete(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}