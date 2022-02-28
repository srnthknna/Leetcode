// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < manager.length; i++) {
            int curr = manager[i];
            if (!graph.containsKey(curr)) {
                graph.put(curr, new ArrayList<>());
            }
            graph.get(curr).add(i);
        }
        
        return dfs(headID, graph, informTime);
    }
    
    private int dfs(int currId, Map<Integer, List<Integer>> graph, int[] informTime) {
        int max = 0;
        if (!graph.containsKey(currId)) {
            return max;
        }
        for (int reportee : graph.get(currId)) {
            max = Math.max(max, dfs(reportee, graph, informTime));
        }
        return max + informTime[currId];
    }
}