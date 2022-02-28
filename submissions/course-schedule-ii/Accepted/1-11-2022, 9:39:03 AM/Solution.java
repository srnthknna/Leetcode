// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<Integer>();
        
        for (int[] pre : prerequisites)
            adj[pre[0]].add(pre[1]);
        
        int[] visited = new int[numCourses];
        int[] ans = new int[numCourses];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++)
            if (visited[i] == 0 && !dfs(adj, visited, i, answer)) return new int[0];

        for (int i = 0; i < answer.size(); i++)
            ans[i] = answer.get(i);
        return ans;
    }
    
    private boolean dfs(List<Integer>[] adj, int[] visited, int v, List<Integer> answer) {
        if (visited[v] == 1) return false;
        if(visited[v] == 2) return true;
        visited[v] = 1;
        for (int ad : adj[v]) 
            if (!dfs(adj, visited, ad, answer)) return false;
        visited[v] = 2;
        answer.add(v);
        return true;
    }
}