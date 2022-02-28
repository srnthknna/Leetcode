// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }
    
    private void dfs(int start, List<List<String>> result, List<String> curr, String s) {
        if (start >= s.length()) result.add(new ArrayList<>(curr));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                dfs(end + 1, result, curr, s);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}