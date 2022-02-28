// https://leetcode.com/problems/middle-of-the-linked-list

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
    public ListNode middleNode(ListNode head) {
        int size = 0, count = 0;
        
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        while (size/2 != count) {
            head = head.next;
            count++;
        }

        return head;
    }
}