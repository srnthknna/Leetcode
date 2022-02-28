// https://leetcode.com/problems/letter-case-permutation

class Solution {
    Set<String> ans = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        solve(s.toCharArray(), 0);
        
        return new ArrayList<>(ans);
    }
    
    private void solve(char[] s, int index) {
        if (index == s.length) {
            ans.add(new String(s));
            return;
        }
        
        solve(s, index + 1);
        
        if (Character.isLetter(s[index])) {
            if (Character.isUpperCase(s[index])) {
                s[index] = Character.toLowerCase(s[index]);
                solve(s, index + 1);
                s[index] = Character.toUpperCase(s[index]);
            } else if (Character.isLowerCase(s[index])) {
                s[index] = Character.toUpperCase(s[index]);
                solve(s, index + 1);
                s[index] = Character.toLowerCase(s[index]);
            }
        }
    }
}