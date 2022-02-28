// https://leetcode.com/problems/minimum-height-trees

// https://www.youtube.com/watch?v=1ZDg3jk7dUE&list=PLEI-q7w3s9gRa-dGulP1CZfN-2w_uiGAK&index=12&ab_channel=CodingDecoded
// Solution is as follows
// Find the indegree for all the nodes and build the adj list
// populate the queue with all the nodes which as the indegree with 1
// it means that when the indegree is 1 its a leaf
// Then its going to be a proper bfs where we find all the neighbhors for the leaf
// reduce the indegree of the neigh considering we are deleting the link to it from the leaf
// once the leaf is deleted if the current indegree of the node becomes 1 then its the potential candidate for the next iteration in the bfs so we add that node to the leaf
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) return result;
        if (n == 1) {
            result.add(0);
            return result;
        }
        
        int[] indegree = new int[n];
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            adjList.putIfAbsent(edge[0], new HashSet<>());
            adjList.putIfAbsent(edge[1], new HashSet<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }
        
        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neigh : adjList.get(curr)) {
                    indegree[neigh]--;
                    adjList.get(neigh).remove(curr);
                    if (indegree[neigh] == 1) {
                        queue.offer(neigh);
                    }
                }
            }
        } 
        return new ArrayList<>(queue);
    }
}