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
        ListNode prev = null, next = null, tempHead = head;
        ListNode leftBefore = null, rightAfter = null;
        while (tempHead != null) {
            if (left == tempHead.val) {
                prev = tempHead;
            }
            if (right == tempHead.val) {
                next = tempHead;
            }
            if (prev == null) {
                leftBefore = tempHead;
            }
            tempHead = tempHead.next;
        }
        
    
        
        if (prev != null && next != null) {
            rightAfter = next.next;
            next = prev;
            ListNode con = next;
            prev = leftBefore;

            while (next != rightAfter) {
                ListNode temp = next.next;
                next.next = prev;
                prev = next;
                next = temp;
            }
            con.next = rightAfter;
        }
        head.next = prev;
        //con.next = rightAfter;
        //System.out.println(con.val);
        //printList(head);
        return head;
    }
    
    private void printList(ListNode temp) {
        for (int i = 0; i < 10; i++) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}