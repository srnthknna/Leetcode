// https://leetcode.com/problems/design-hit-counter

class HitCounter {
    Queue<Integer> hits = new LinkedList<Integer>();
    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (! hits.isEmpty()) {
            int diff = timestamp - hits.peek();
            if (diff >= 300) hits.remove();
            else break;
        }
        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */