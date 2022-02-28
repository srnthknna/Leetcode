// https://leetcode.com/problems/design-hashmap

class MyHashMap {
    
    class Entry {
        int key;
        int value;
        
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    LinkedList<Entry>[] map;
    private static int SIZE = 769;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % SIZE;
        LinkedList<Entry> nodes = map[bucket];
        if (nodes != null) {
            for (Entry entry : nodes) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            nodes.add(new Entry(key, value));
            
        } else {
            map[bucket] = new LinkedList<>();
            map[bucket].add(new Entry(key, value));
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % SIZE;
        if (map[bucket] != null) {
            LinkedList<Entry> nodes = map[bucket];
            for (Entry entry : nodes) {
                if (entry.key == key)
                    return entry.value;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % SIZE;
        Entry toRemove = null;
        if (map[bucket] != null) {
            LinkedList<Entry> nodes = map[bucket];
            for (Entry entry : nodes) {
                if (entry.key == key)
                    toRemove = entry;
            }
        }
        if (toRemove != null) {
            map[bucket].remove(toRemove);   
        }   
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */