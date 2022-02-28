// https://leetcode.com/problems/strobogrammatic-number-ii

class Solution {
    char[][] mapping = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) return res;
        char[] chrs = new char[n];
        helper(res, chrs, 0, n - 1);
        return res;
    }
    
    private void helper(List<String> res, char[] chrs, int low, int high) {
        if (low > high ) {
            if (chrs.length == 1 || chrs[0] != '0') {
                res.add(String.valueOf(chrs));
            }
            return;
        }
        
        for (char[] map : mapping) {
        
            if (low == high && map[0] != map[1]) {
                continue;
            }
            chrs[low] = map[0];
            chrs[high] = map[1];
            helper(res, chrs, low + 1, high - 1);
        }
        
    }
}