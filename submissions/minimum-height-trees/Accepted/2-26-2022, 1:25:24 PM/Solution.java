// https://leetcode.com/problems/minimum-height-trees

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
        
        int count = n;
        while (count > 2) {
            int size = queue.size();
            count -= size;
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