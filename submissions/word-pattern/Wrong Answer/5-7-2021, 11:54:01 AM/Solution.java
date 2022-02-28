// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> table = new HashMap<>();
        Map<String, Character> revTab = new HashMap<>();
        if (words.length != pattern.length()) return false;
        
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (table.containsKey(c)) {
                if (!words[i].equals(table.get(c))) return false;
                if (revTab.get(words[i]) != c) return false;
            } else {
                table.put(c, words[i]);
                revTab.put(words[i], c);
            }
        }
        return true;
    }
}