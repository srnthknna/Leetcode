// https://leetcode.com/problems/design-hashset

class MyHashSet {
    
    LinkedList<Entry>[] map;
    private static int SIZE = 769;
    
    class Entry {
        int key;
        public Entry(int key) {
            this.key = key;
        }
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new LinkedList[SIZE];
    }
    
    public void add(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> nodes = map[bucket];
        if (nodes != null) {
            for (Entry i : nodes)
                if (i.key == key)
                    return;
            nodes.add(new Entry(key));
        } else {
            map[bucket] = new LinkedList<>();
            map[bucket].add(new Entry(key));
        }
    }
    
    public void remove(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> nodes = map[bucket];
        Entry toRemove = null;
        if (nodes != null) {
            for (Entry node : nodes) {
                if (node.key == key)
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
        LinkedList<Entry> nodes = map[bucket];
        if (nodes != null) {
            for (Entry node : nodes) {
                if (node.key == key)
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */