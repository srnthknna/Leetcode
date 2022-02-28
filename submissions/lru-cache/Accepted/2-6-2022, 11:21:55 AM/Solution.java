// https://leetcode.com/problems/lru-cache

class LRUCache {
    
    // Dummy head to track where our linkedlist begins
    Node head = new Node();
    // Dummy tail to track where our linkedlist ends
    Node tail = new Node();
    Map<Integer, Node> nodeMap;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = nodeMap.get(key);
        // Key exists in the map
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            // case to update as the map does not have prev reference
            remove(node);
            node.val = value;
            add(node);
        } else {
            // Add this node fresh
            
            // If we are at capacity
            if (capacity == nodeMap.size()) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            
            nodeMap.put(key, newNode);
            add(newNode);
        }
    }
    
    /*
    Add the node to the linkedlist right after current head
    */
    private void add(Node node) {
        // where our prev linkedlist began
        Node headNext = head.next;
        headNext.prev = node;
        node.next = headNext;
        head.next = node;
        node.prev = head;
    }
    
    private void remove(Node node) {
        // get the next node
        Node nodeNext = node.next;
        // get the prev node
        Node nodePrev = node.prev;
        // link them
        nodeNext.prev = nodePrev;
        nodePrev.next = nodeNext;
    }
    
    class Node {
        // We need this to track what needs to be removed from the map 
        int key;
        // Rest all is just to track the double linked list
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */