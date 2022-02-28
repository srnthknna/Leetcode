// https://leetcode.com/problems/shortest-word-distance-ii

class WordDistance {
    String[] words;
    public WordDistance(String[] words) {
        this.words = words;
    }
    
    public int shortest(String word1, String word2) {
        int i1 = -1, i2 = -1, minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                i1 = i;
            } else if (word2.equals(words[i])) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */