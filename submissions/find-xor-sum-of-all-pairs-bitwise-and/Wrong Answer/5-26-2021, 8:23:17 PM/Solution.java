// https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and

class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xora = 0, xorb = 0;
        for (int a1: arr1)
            xora &= a1;
        for (int a2: arr2)
            xorb &= a2;
        return xora ^ xorb;
    }
}