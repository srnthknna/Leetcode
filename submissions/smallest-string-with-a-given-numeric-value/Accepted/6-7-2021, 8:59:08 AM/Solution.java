// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value

class Solution {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int position = n - 1; position >= 0; position--) {
            int add = Math.min(k - position, 26);
            result[position] = (char) (add + 96);
            k -= add;
        }
        return String.valueOf(result);
    }
}