// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * } 1 2 3
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        return prev;
    }
}