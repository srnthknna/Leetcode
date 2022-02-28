// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero

class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        
        int val = n / 2, val1 = val, i = 0;
        
        while (i < n / 2) {
            result[i++] = -1 * val--;
        }
        
        i = n / 2;
        
        if (n % 2 == 1)  { 
            result[val1] = 0;
            i++;
        }
        
        while (i < n) {
            result[i++] = val1--;
        }
        return result;
    }
}