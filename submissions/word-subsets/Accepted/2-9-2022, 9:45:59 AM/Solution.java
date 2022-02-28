// https://leetcode.com/problems/word-subsets

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] maxFrequencies = new int[26];
        for (String word : words2) {
            int[] currFrequencies = getFrequencies(word);
            for (int i = 0; i < 26; i++) {
                maxFrequencies[i] = Math.max(maxFrequencies[i], currFrequencies[i]);
            }
        }
        
        for (String word : words1) {
            int[] currFrequencies = getFrequencies(word);
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (maxFrequencies[i] > currFrequencies[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) result.add(word);
        }
        return result;
    }
    
    private int[] getFrequencies(String word) {
        int[] counts = new int[26];
        for (char c : word.toCharArray())
            counts[c - 'a']++;
        return counts;
    }
}