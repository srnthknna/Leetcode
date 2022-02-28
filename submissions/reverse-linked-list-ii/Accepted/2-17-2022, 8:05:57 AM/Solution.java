// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode curr = head, prev = null;
        
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        
        ListNode con = prev, tail = curr, third = null;
        
        while (right > 0) {
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            right--;
        }
        
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        
        tail.next = third;
        return head;
    }

}