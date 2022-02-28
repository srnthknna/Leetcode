// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res.add(i);
            }
            if (res.size() > 2) return false;
        }
        return res.size() == 0 || (res.size() == 2 && s1.charAt(res.get(0)) == s2.charAt(res.get(1)) &&
            s1.charAt(res.get(1)) == s2.charAt(res.get(0)));
    }
}