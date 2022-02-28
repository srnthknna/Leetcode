// https://leetcode.com/problems/sentence-similarity-ii

class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        
        Map<String, Set<String>> g = new HashMap<>();
        buildGraph(g, similarPairs);
        
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;
            if (!dfs(g, sentence1[i], sentence2[i], new HashSet<>())) return false;
        }
        return true;
    }
    
    private void buildGraph(Map<String, Set<String>> g, List<List<String>> similarPairs) {
        for (List<String> pair : similarPairs) {
            g.computeIfAbsent(pair.get(0), k -> new HashSet<>()).add(pair.get(1));
            g.computeIfAbsent(pair.get(1), k -> new HashSet<>()).add(pair.get(0));
        }
    }
    
    private boolean dfs(Map<String, Set<String>> g, String word1, String word2, Set<String> visited) {
        if (g.get(word1) == null || g.get(word1).size() == 0) return false;
        if (g.get(word1).contains(word2)) return true;
        for (String neigh : g.get(word1)) {
            if (visited.add(neigh)) {
                if (dfs(g, neigh, word2, visited)) return true;
            }
        }
        return false;
    }
}