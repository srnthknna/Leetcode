// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode sizeFinder = head;
        while (sizeFinder != null) {
            sizeFinder = sizeFinder.next;
            size++;
        }
        if (size == 0 || k % size == 0) return head;
        k = k % size;

        head =  reverse(head, null);
        
        ListNode kth = head, newhead = head;
        while (k > 0 && kth != null) {
            kth = kth.next;
            k--;
        }
        head = reverse(newhead, kth);
        newhead = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = reverse(kth, null);
        return newhead;
    }
    
    private ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = null;
        while (head != end) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}