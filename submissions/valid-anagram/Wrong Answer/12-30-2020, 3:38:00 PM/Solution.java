// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> m = new HashMap<>(), n = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (m.containsKey(c)) m.put(c, m.get(c) + 1);
            else m.put(c, 1);
        }
        
        for (char c : t.toCharArray()) {
            if (n.containsKey(c)) n.put(c, n.get(c) + 1);
            else n.put(c, 1);
        }
        
        for (char c : m.keySet()) {
            if (m.get(c) != n.get(c)) return false;
        }
        return true;
    }
}