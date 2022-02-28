// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        Map<Character, Character> diff = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.containsKey(s1.charAt(i))) return false;
                else diff.put(s1.charAt(i), s2.charAt(i));
            }
            if (diff.size() > 2) return false;
        }
        if (diff.size() == 0) return true;
        for (char c : diff.keySet()) {
            if (!diff.containsKey(diff.get(c))) return false;
        }
        return true;
    }
}