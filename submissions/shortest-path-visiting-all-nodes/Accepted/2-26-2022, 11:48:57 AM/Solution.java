// https://leetcode.com/problems/shortest-path-visiting-all-nodes

class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) return 0;
        int shortest = 0, n = graph.length;
        
        int finalState = (1 << n) - 1;
        
        int[][] visited = new int[n][finalState + 1];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n ; i++) {
            queue.offer(new int[] {i, 1 << i});
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            shortest++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currNode = curr[0], currState = curr[1];
                
                for (int neigh : graph[currNode]) {
                    int nextState = currState | (1 << neigh);
                    if (visited[neigh][nextState] == 1) continue;
                    visited[neigh][nextState] = 1;
                    if (nextState == finalState) return shortest;
                    queue.offer(new int[] {neigh, nextState});
                }
            }
        }
        return -1;
    }
}