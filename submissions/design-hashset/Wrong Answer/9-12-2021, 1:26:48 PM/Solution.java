// https://leetcode.com/problems/design-hashset

class MyHashSet {
    
    LinkedList<Integer>[] map;
    private static int SIZE = 769;

    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new LinkedList[SIZE];
    }
    
    public void add(int key) {
        int bucket = key % SIZE;
        LinkedList<Integer> nodes = map[bucket];
        if (nodes != null) {
            for (int i : nodes)
                if (i == key)
                    return;
        }
        map[bucket] = new LinkedList<>();
        map[bucket].add(key);
    }
    
    public void remove(int key) {
        int bucket = key % SIZE;
        LinkedList<Integer> nodes = map[bucket];
        Integer toRemove = null;
        if (nodes != null) {
            for (int node : nodes) {
                if (node == key)
                    toRemove = node;
            }
        }
        if (toRemove == null)
            return;
        else
            nodes.remove(toRemove);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = key % SIZE;
        LinkedList<Integer> nodes = map[bucket];
        return nodes != null ? nodes.contains(key) : false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */