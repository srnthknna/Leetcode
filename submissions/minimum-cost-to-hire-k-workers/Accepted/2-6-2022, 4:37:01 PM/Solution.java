// https://leetcode.com/problems/minimum-cost-to-hire-k-workers

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Pair<Integer, Integer>[] workers = new Pair[n];
        for (int i = 0; i < n; i++)
            workers[i] = new Pair<>(quality[i], wage[i]);
        Arrays.sort(workers, (a, b) -> Double.compare((double)a.getValue()/a.getKey(), (double)b.getValue()/b.getKey()));
        
        double ans = Double.MAX_VALUE;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Pair<Integer, Integer> worker : workers) {
            pq.offer(-worker.getKey());
            sum += worker.getKey();
            if (pq.size() > k)
                sum += pq.poll();
            if (pq.size() == k)
                ans = Math.min(ans, sum * ((double)worker.getValue() / worker.getKey()));
        }
        
        return ans;
    }
}