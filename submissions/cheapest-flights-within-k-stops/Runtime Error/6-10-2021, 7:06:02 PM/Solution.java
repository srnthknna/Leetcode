// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (flights.length == 0) return -1;
        
        Map<Integer, List<int[]>> graph = buildGraph(flights); 
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.cost - b.cost));
        
        pq.add(new Node(src, 0, 0));
        int[] minHops = new int[graph.size()];
        Arrays.fill(minHops, -1);
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.dst == dst)
                return cur.cost;
            
            if (cur.stop > k) continue;
            if (minHops[cur.dst] != -1 && minHops[cur.dst] < cur.stop) continue;

            List<int[]> next_hops = graph.getOrDefault(cur.dst, new ArrayList<>());

            for (int[] next_hop : next_hops) {
                pq.add(new Node(next_hop[0], cur.cost + next_hop[1], cur.stop + 1));
            }

        }
        return -1;
    }
    
    private Map<Integer, List<int[]>> buildGraph(int[][] flights) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return graph;
    }
    
    class Node {
        int dst;
        int cost;
        int stop;
        
        public Node(int dst, int cost, int stop) {
            this.dst = dst;
            this.cost = cost;
            this.stop = stop;
        }
    }
}