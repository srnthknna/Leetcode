// https://leetcode.com/problems/replace-words

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> words = new HashSet<>();
        for (String word : dictionary) {
            words.add(word);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String word: sentence.split("\\s+")) {
            StringBuilder  cur = new StringBuilder();
            for (char c : word.toCharArray()) {
                cur.append(c);
                if (words.contains(cur.toString())) {
                    break;
                }
            }
            if (sb.length() > 0) sb.append(" ");
            sb.append(cur.toString());
        }
        return sb.toString();
    }
}