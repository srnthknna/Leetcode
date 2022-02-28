// https://leetcode.com/problems/course-schedule

class Solution {
    private static final int NOT_VISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<Integer>();
        
        for (int[] pre : prerequisites)
            adj[pre[0]].add(pre[1]);
        
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            if (visited[i] == NOT_VISITED && !dfs(adj, visited, i)) return false;
        return true;
    }
    
    private boolean dfs(List<Integer>[] adj, int[] visited, int v) {
        if (visited[v] == VISITING) return false;
        if(visited[v] == VISITED) return true;
        visited[v] = VISITING;
        for (int ad : adj[v]) 
            if (!dfs(adj, visited, ad)) return false;
        visited[v] = VISITED;
        return true;
    }
}