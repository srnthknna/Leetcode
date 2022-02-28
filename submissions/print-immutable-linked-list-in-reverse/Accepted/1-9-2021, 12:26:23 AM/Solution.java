// https://leetcode.com/problems/print-immutable-linked-list-in-reverse

/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
            
        }
        
        helper(head, null);
    }
    
    private void helper(ImmutableListNode start, ImmutableListNode end) {
        if (start == null || start == end) {
            return;
            
        } else if (start.getNext() == end) {
            start.printValue();
            return;
        }
        
        ImmutableListNode slow = start,
            fast = start;
        
        while (fast != end && fast.getNext() != end) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        
        helper(slow, end);
        helper(start, slow);
    }
}