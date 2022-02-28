// https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list

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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode headC = head, dummyC = dummy;
        Map<Integer, Integer> map = new HashMap<>();
        
        while (headC != null) {
            map.put(headC.val, map.getOrDefault(headC.val, 0) + 1);
            headC = headC.next;
        }
        
        headC = head;
        
        while (headC != null) {
            if (map.get(headC.val) == 1) {
                dummy.next = headC;
                dummy = dummy.next;
            }
            headC = headC.next;
        }
        
        dummy.next = null;
        return dummyC.next;
    }
}