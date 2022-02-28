// https://leetcode.com/problems/longest-string-chain

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        
        Map<String, Integer> map = new HashMap<>();
        
        int ans = 0;
        for (String word : words) {
            int currLength = 0;
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + word.substring(i + 1, word.length());
                currLength = Math.max(currLength, map.getOrDefault(newWord, 0) + 1);
            }
            map.put(word, currLength);
            ans = Math.max(ans, currLength);
        }
        return ans;
    }
}