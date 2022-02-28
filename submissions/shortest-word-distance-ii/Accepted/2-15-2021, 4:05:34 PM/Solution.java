// https://leetcode.com/problems/shortest-word-distance-ii

class WordDistance {
    HashMap<String, ArrayList<Integer>> locations;
    public WordDistance(String[] words) {
        this.locations = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> loc = locations.getOrDefault(words[i], new ArrayList<>());
            loc.add(i);
            locations.put(words[i], loc);
        }
    }
    
    public int shortest(String word1, String word2) {
        ArrayList<Integer> loc1 = locations.get(word1), loc2 = locations.get(word2);
        int i1 = 0, i2 = 0, minDistance = Integer.MAX_VALUE;
        while (i1 < loc1.size() && i2 < loc2.size()) {
            minDistance = Math.min(minDistance, Math.abs(loc1.get(i1) - loc2.get(i2)));
            if (loc1.get(i1) < loc2.get(i2)) i1++;
            else i2++;
        }
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */