// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(), prev = dummy;
        while (head != null) {
            int count = 1;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                count++;
            }
            if (count <= 1) {
                dummy.next = head;
                dummy = head;
            }
            head = head.next;
        }
        return prev.next;
    }
}