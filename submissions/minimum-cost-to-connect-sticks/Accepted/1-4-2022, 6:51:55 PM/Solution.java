// https://leetcode.com/problems/minimum-cost-to-connect-sticks

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;
        
        for (int stick : sticks)
            pq.add(stick);
        
        while (pq.size() > 1) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            
            int cost = stick1 + stick2;
            total += cost;
            pq.add(cost);
        }
        
        return total;
    }
}