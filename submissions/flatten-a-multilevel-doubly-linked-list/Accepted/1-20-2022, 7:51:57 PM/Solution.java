// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node pseudoHead = new Node(0, null, head, null);
        
        dfs(pseudoHead, head);
        
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
    
    private Node dfs(Node prev, Node curr) {
        if (curr == null) return prev;
        
        prev.next = curr;
        curr.prev = prev;
        
        Node tempNext = curr.next;
        
        Node tail = dfs(curr, curr.child);
        curr.child = null;
        return dfs(tail, tempNext);
    }
}