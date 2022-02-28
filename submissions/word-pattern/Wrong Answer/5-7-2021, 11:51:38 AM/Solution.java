// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> table = new HashMap<>();
        if (words.length != pattern.length()) return false;
        
        for (int i = 0; i < pattern.length(); i++) {
            if (table.containsKey(pattern.charAt(i))) {
                if (!words[i].equals(table.get(pattern.charAt(i)))) return false;
            } else {
                table.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }
}