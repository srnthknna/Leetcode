// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (flights.length == 0) return -1;
        
        Map<Integer, List<Node>> graph = buildGraph(flights); 
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int[] minHops = new int[n];
        Arrays.fill(minHops, -1);
        
        pq.add(new Node(src, 0, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.dst == dst)
                return cur.cost;
            if (cur.stop > k) continue;
            if (minHops[cur.dst] != -1 && minHops[cur.dst] < cur.stop) continue;
                minHops[cur.dst] = cur.stop;
            
            List<Node> next_hops = graph.getOrDefault(cur.dst, new ArrayList<Node>());
            for (Node next_hop : next_hops) {
                pq.add(new Node(next_hop.dst, cur.cost + next_hop.cost, cur.stop + 1));
            }

        }
        return -1;
    }
    
    private Map<Integer, List<Node>> buildGraph(int[][] flights) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<Node>());
            graph.get(flight[0]).add(new Node(flight[1], flight[2], 0));
        }
        return graph;
    }
    
    class Node implements Comparable<Node> {
        int dst;
        int cost;
        int stop;
        
        public Node(int dst, int cost, int stop) {
            this.dst = dst;
            this.cost = cost;
            this.stop = stop;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}