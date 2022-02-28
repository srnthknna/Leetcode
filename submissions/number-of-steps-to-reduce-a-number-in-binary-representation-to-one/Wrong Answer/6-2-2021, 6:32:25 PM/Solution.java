// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one

class Solution {
    public int numSteps(String s) {
        int res = 0, carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res++;
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                res++;
            }
        }
        return res;
    }
}