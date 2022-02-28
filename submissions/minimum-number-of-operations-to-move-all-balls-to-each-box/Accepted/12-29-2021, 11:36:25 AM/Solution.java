// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n], right = new int[n], result = new int[n];
        
        int balls = boxes.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + balls;
            balls += boxes.charAt(i) - '0';
        }
        
        balls = boxes.charAt(n - 1) - '0';
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + balls;
            balls += boxes.charAt(i) - '0';
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = left[i] + right[i];
        }
        return result;
    }
}