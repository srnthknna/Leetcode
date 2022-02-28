// https://leetcode.com/problems/merge-k-sorted-lists

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        
        for (ListNode list : lists) {
            if (list != null)
                pq.offer(list);
        }
        
        while(!pq.isEmpty()) {
            ListNode small = pq.poll();
            curr.next = small;
            curr = curr.next;
            if (small.next != null)
                pq.offer(small.next);
        }
        
        return dummy.next;
    }
}