// https://leetcode.com/problems/candy

class Solution {
    public int candy(int[] ratings) {
        int sum = 0, n = ratings.length;
        
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = 1 + left[i - 1];
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = 1 + right[i + 1];
            }
        }
        
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}