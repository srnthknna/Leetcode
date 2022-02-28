// https://leetcode.com/problems/unique-morse-code-words

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> unique = new HashSet<>();
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (char c: word.toCharArray()) {
                sb.append(morse[c-'a']);
            }
            unique.add(sb.toString());
        }
        return unique.size();
    }
}