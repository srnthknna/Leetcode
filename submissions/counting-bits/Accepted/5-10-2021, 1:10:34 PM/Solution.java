// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        /*
          Last set bit is the rightmost set bit. Setting that bit to zero with the bit trick, x &= x - 1, leads to the following transition function:

P(x) = P(x \mathrel{\&} (x - 1)) + 1;P(x)=P(x&(x−1))+1;
        */
        for (int i = 1; i <= num; i++) 
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}