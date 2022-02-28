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

class Solution1 {
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

class Solution {
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node ptr = head;
        
        // A->A`->B->B`
        while (ptr != null) {
            Node node = new Node(ptr.val);
            node.next = ptr.next;
            ptr.next = node;
            ptr = node.next;
        }
        
        ptr = head;
        
        while (ptr != null) {
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        
        Node oldHead = head;
        Node newHead = head.next, returnHead = newHead;
        
        while (oldHead != null) {
            oldHead.next = oldHead.next.next;
            newHead.next = (newHead.next != null) ? newHead.next.next : null;
            oldHead = oldHead.next;
            newHead = newHead.next;
        }
        
        return returnHead;   
    }
}