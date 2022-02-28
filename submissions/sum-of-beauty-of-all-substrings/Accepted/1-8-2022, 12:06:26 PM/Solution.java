// https://leetcode.com/problems/sum-of-beauty-of-all-substrings

class Solution {
    public int beautySum(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                int m_f = Integer.MIN_VALUE, l_f = Integer.MAX_VALUE;
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                for (int val : map.values()) {
                    m_f = Math.max(m_f, val);
                    l_f = Math.min(l_f, val);
                }
                ans += m_f - l_f;
            }
        }
        return ans;
    }
}