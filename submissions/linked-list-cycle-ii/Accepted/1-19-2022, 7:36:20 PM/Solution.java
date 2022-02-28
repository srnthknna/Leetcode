// https://leetcode.com/problems/linked-list-cycle-ii

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        
        ListNode intersect = intersect(head);
        
        if (intersect == null) return null;
        
        ListNode pt1 = head, pt2 = intersect;
        while (pt1 != pt2) {
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        return pt1;
    }
    
    private ListNode intersect(ListNode head) {
        ListNode tortoise = head, hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (hare == tortoise)
                return hare;
        }
        return null;
    }
}