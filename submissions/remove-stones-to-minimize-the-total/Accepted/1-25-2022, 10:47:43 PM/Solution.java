// https://leetcode.com/problems/remove-stones-to-minimize-the-total

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int res = 0;
        
        for (int pile : piles) {
            res += pile;
            pq.offer(pile);
        }
        
        while (k-- > 0) {
            int a = pq.poll();
            res -= a / 2;
            pq.offer(a - a/ 2);
        }
        return res;
    }
}