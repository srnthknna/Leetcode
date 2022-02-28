// https://leetcode.com/problems/network-delay-time

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
        buildGraph(times, adj);
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        pq.offer(new Pair<>(k, 0));
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> currPair = pq.poll();
            int currNode = currPair.getKey();
            int currTime = currPair.getValue();
            
            if (currTime > distance[currNode]) continue;
            
            if (!adj.containsKey(currNode)) continue;
            
            for (Pair<Integer, Integer> neigh : adj.get(currNode)) {
                if (currTime + neigh.getValue() < distance[neigh.getKey()]) {
                    distance[neigh.getKey()] = currTime + neigh.getValue();
                    pq.offer(new Pair<>(neigh.getKey(), currTime + neigh.getValue()));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(distance[i], max);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    
    private void buildGraph(int[][] times, Map<Integer, List<Pair<Integer, Integer>>> adj) {
        for (int[] time : times) {
            adj.putIfAbsent(time[0], new ArrayList<>());
            adj.get(time[0]).add(new Pair<>(time[1], time[2]));
        }
    }
}