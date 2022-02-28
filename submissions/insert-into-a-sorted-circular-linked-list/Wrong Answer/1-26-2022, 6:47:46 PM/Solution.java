// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        
        
        Node curr = head.next, prev = head;
         
         do {
            if (prev.val <= insertVal && insertVal <= head.val) {
                prev.next = new Node(insertVal, curr);
                return head;
            } else if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    prev.next = new Node(insertVal, curr);
                    return head;
                }
            }
            prev = curr;
            curr = curr.next;
        } while (prev != head);
        
        head.next = new Node(insertVal, curr);
        return head;
    }
}