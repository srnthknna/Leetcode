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
        
        
        Node next = head.next, copyHead = head, tail = head;
        
        if (head == next) {
            head.next = new Node(insertVal);
            head.next.next = head;
            return head;
        }
        
        while (next != copyHead) {
            if (head.val < insertVal && insertVal > next.val) {
                head.next = new Node(insertVal, next);
                return copyHead;
            } else if (head.val > next.val) {
                //head = head.next;
                if (insertVal >= head.val || insertVal <= next.val) {
                    head.next = new Node(insertVal, next);
                    return copyHead;
                }
            }
            head = next;
            next = next.next;
        }
        head.next = new Node(insertVal, next);
        return copyHead;
    }
}