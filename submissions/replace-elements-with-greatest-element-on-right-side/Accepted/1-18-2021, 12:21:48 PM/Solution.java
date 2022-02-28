// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length,  max = arr[n - 1], temp;
        for (int i = n - 2; i >= 0; i--) {
            temp = Math.max(max, arr[i]);
            arr[i] = max;
            max = temp;
        }
        arr[n - 1] = -1;
        return arr;
    }
}