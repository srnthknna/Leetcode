// https://leetcode.com/problems/di-string-match

class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length(), hi = n, low = 0;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I') result[i] = low++;
            else result[i] = hi--;
        }
        result[n] = low;
        return result;
    }
}