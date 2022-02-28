// https://leetcode.com/problems/merge-in-between-linked-lists

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aMinus = null, bPlus = null;
        ListNode tmp = list1, next;;
        int size = 0;
        while (tmp != null && (aMinus == null || bPlus == null)) {
            next = tmp.next;
            if (next != null) {
                if (size == a - 1) aMinus = tmp;
                if (size == b) bPlus = next;
            }
            tmp = next;
            size++;
        }
        
        aMinus.next = list2;
        
        while (list2.next != null) {
            list2 = list2.next;
        }
        
        list2.next = bPlus;
        
        return list1;
    }
}