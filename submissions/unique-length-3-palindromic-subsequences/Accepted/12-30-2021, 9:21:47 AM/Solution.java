// https://leetcode.com/problems/unique-length-3-palindromic-subsequences

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] left = new int[26], right = new int[26];
        int res = 0;
        
        Arrays.fill(left, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            left[s.charAt(i) - 'a'] = Math.min(left[s.charAt(i) - 'a'], i);
            right[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < 26; i++) {
            Set<Character> set = new HashSet<>();
            if (left[i] < right[i]) {
                for (int c = left[i] + 1; c < right[i]; c++) {
                    set.add(s.charAt(c));
                }
                res += set.size();
            }
        }
        return res;
    }
}