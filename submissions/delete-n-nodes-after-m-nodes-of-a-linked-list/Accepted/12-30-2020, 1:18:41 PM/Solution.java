// https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list

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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode temp = head, lastMHead = head;
        
        while(head != null) {
            int mC = 0, nC = 0;
            while (mC != m && head != null) {
                lastMHead = head;
                head = head.next;
                mC++;
            }
            while (nC != n  && head != null) {
                head = head.next;
                nC++;
            }
            lastMHead.next = head;
        }
            
        return temp;
    }
}