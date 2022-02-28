// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        Map<Character, Integer> diff = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.containsKey(s1.charAt(i))) return false;
                else diff.put(s1.charAt(i), i);
            }
        }
        return diff.size() == 0 || diff.size() == 2;
    }
}