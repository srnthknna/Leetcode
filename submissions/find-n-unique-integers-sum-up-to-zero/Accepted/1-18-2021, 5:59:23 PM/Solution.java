// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero

class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int val = n / 2, val1 = val;
        for (int i = 0; i < n / 2; i++) {
            result[i] = -1 * val--;
        }
        int i = n / 2;
        if (n % 2 == 1)  { 
            result[val1] = 0;
            i++;
        }
        for (; i < n; i++) {
            result[i] = val1--;
        }
        return result;
    }
}