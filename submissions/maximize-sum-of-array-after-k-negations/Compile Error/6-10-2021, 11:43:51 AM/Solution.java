// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(arr);
        int sum = 0, len = arr.length, minIndex = 0;
        while (k > 0) {
            arr[minIndex] *= -1;
            k--;
            if (minIndex + 1 < len && arr[minIndex] > arr[minIndex + 1]) minIndex++;
        }
        
        for (int i : arr) sum += i;
        
        return sum;
    }
}