// https://leetcode.com/problems/sentence-similarity

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        
        Map<String, Set<String>> pairMap = new HashMap<>();
        
        for (List<String> pairs : similarPairs) {
            pairMap.computeIfAbsent(pairs.get(0), k -> new HashSet<>()).add(pairs.get(1));
            pairMap.computeIfAbsent(pairs.get(1), k -> new HashSet<>()).add(pairs.get(0));
        }
        
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;
            
            if (pairMap.containsKey(sentence1[i]) && pairMap.get(sentence1[i]).contains(sentence2[i])) {
                continue;
            } return false;
        }
        return true;
    }
}