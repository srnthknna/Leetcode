// https://leetcode.com/problems/copy-list-with-random-pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> cloneMap = new HashMap<>();
    
    private Node createClone(Node oldNode) {
        if (oldNode == null) return null;
        
        if (cloneMap.containsKey(oldNode)) {
            return cloneMap.get(oldNode);
        }
        Node newNode = new Node(oldNode.val, null, null);
        cloneMap.put(oldNode, newNode);
        return newNode;
    }
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node oldNode = head;
        Node newNode = new Node(head.val);
        cloneMap.put(oldNode, newNode);
        
        while (oldNode != null) {
            newNode.next = createClone(oldNode.next);
            newNode.random = createClone(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return cloneMap.get(head);
    }
}