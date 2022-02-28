// https://leetcode.com/problems/guess-the-word

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            int[][] dist = new int[6][26];
            for (String word : wordlist) {
                for (int k = 0; k < 6; k++) {
                    dist[k][word.charAt(k) - 'a']++;
                }
            }
            String guess = bestCandidate(wordlist, dist);
            x = master.guess(guess);
            List<String> wordsNext = new ArrayList<>();
            for (String word : wordlist) {
                if (match(word, guess) == x)
                    wordsNext.add(word);
            }
            wordlist = wordsNext.toArray(new String[wordsNext.size()]);
        }
    }
    
    private int match(String word1, String word2) {
        int match = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i))
                match++;
        }
        return match;
    }
    
    private String bestCandidate(String[] wordlist, int[][] dist) {
        int max = 0;
        String res = "";
        for (String word : wordlist) {
            int score = 1;
            for (int i = 0; i < 6; i++) {
                score *= dist[i][word.charAt(i) - 'a'];
            }
            if (score > max) {
                max = score;
                res = word;
            }
        }
        return res;
    }
}