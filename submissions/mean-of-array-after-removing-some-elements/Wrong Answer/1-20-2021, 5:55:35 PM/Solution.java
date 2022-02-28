// https://leetcode.com/problems/mean-of-array-after-removing-some-elements

class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length / 20;
        Arrays.sort(arr);
        
        int sum = 0;
        for (int i = n; i < arr.length - n; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * n);
    }
}