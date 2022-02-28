// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> counts.get(a) - counts.get(b));
        for (int num : counts.keySet()) {
            pq.add(num);
            // if (pq.size() > k) {
            //     pq.poll();
            // }
        }
        
        int[] result = new int[pq.size()];
        int i = 0;
        for (int num : pq) {
            result[i++] = num;
        }
        return result;
    }
}