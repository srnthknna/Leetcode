// https://leetcode.com/problems/generalized-abbreviation

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), word, 0, 0);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder sb, String word, int i, int k) {
        int len = sb.length();
        
        if (i == word.length()) {
            if (k != 0) sb.append(k);
            result.add(sb.toString());
        } else {
            backtrack(result, sb, word, i + 1, k + 1);
            
            if (k != 0) sb.append(k);
            sb.append(word.charAt(i));
            backtrack(result, sb, word, i + 1, 0);
        }
        
        sb.setLength(len);
    }
}