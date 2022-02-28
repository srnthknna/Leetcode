// https://leetcode.com/problems/distant-barcodes

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        
        for (int code : barcodes) {
            map.put(code, map.getOrDefault(code, 0) + 1);
        }
        pq.addAll(map.keySet());
        
        int[] result = new int[barcodes.length];
        int index = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            result[index++] = a;
            
            if (!pq.isEmpty()) {
                int b = pq.poll();
                result[index++] = b;
                update(map, pq, a);
                update(map, pq, b);
            }
        }
        
        return result;
    }
    
    private void update(Map<Integer, Integer> map, PriorityQueue<Integer> pq, int val) {
        int freq = map.get(val);
        if (freq == 1) {
            map.remove(val);
        } else {
            map.put(val, freq - 1);
            pq.offer(val);
        }
    }
}