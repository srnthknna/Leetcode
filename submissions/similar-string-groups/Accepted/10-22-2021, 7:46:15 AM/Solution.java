// https://leetcode.com/problems/similar-string-groups

class Solution {
    public int numSimilarGroups(String[] strs) {
        Map<String, Set<String>> g = new HashMap<>();
        buildGraph(strs, g);
        int count = 0;
        Set<String> visited = new HashSet<>();
        
        for (String key : g.keySet()) {
            if (visited.add(key)) {
                dfs(visited, g, key);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(Set<String> visited, Map<String, Set<String>> g, String a) {
        for (String neigh : g.get(a)) {
            if (visited.add(neigh)) {
                dfs(visited, g, neigh);
            }
        }
    }
    
    private void buildGraph(String[] strs, Map<String, Set<String>> g) {
        for (String s : strs) {
            g.put(s, new HashSet<>());
        }
        int n = strs.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    g.get(strs[i]).add(strs[j]);
                    g.get(strs[j]).add(strs[i]);
                }
            }
        }
    }
    
    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2)
                    return false;
            }
        }
        return true;
    }
}