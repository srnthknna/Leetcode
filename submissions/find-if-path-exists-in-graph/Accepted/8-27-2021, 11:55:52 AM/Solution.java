// https://leetcode.com/problems/find-if-path-exists-in-graph

class Solution {
    int[] par;
    
    private int findPar(int u) {
        return par[u] == u ? u : findPar(par[u]);    
    }
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        par = new int[n];
        
        for (int i = 0; i < n; i++)
            par[i] = i;
        
        for (int[] e: edges) {
            int p0 = findPar(e[0]);
            int p1 = findPar(e[1]);
            
            if (p0 != p1) {
                par[p0] = p1;
            }
            
        }
        
        return findPar(start) == findPar(end);
    }
}