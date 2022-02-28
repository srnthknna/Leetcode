// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (!graph.containsKey(manager[i])) {
                graph.put(manager[i], new ArrayList<>());
            }
            graph.get(manager[i]).add(i);
        }
        return dfs(headID, graph, informTime);       
    }
    
    private int dfs(int curr, Map<Integer, List<Integer>> graph, int[] informTime) {
        int max = 0;
        
        if (!graph.containsKey(curr))
            return max;
        
        for (int reportee : graph.get(curr)) {
            max = Math.max(max, dfs(reportee, graph, informTime));
        }
        
        return max + informTime[curr];
    }
}