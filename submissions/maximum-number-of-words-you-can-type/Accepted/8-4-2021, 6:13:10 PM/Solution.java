// https://leetcode.com/problems/maximum-number-of-words-you-can-type

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) 
            set.add(c);
        String[] words = text.split(" ");
        int ans = words.length;
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (set.contains(c)) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}