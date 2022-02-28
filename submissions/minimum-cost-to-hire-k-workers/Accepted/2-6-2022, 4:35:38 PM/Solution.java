// https://leetcode.com/problems/minimum-cost-to-hire-k-workers

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);
        
        double ans = Double.MAX_VALUE;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Worker worker : workers) {
            pq.offer(-worker.quality);
            sum += worker.quality;
            if (pq.size() > k)
                sum += pq.poll();
            if (pq.size() == k)
                ans = Math.min(ans, sum * worker.ratio());
        }
        
        return ans;
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage;
    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio());
    }
}