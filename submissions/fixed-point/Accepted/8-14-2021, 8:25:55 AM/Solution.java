// https://leetcode.com/problems/fixed-point

class Solution1 {
    public int fixedPoint(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] - m < 0)
                l = m + 1;
            else
                r = m;
        }
        return arr[l] == l ? l : -1;
    }
}
class Solution {
    public int fixedPoint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == i)
                return i;
        return -1;
    }
}