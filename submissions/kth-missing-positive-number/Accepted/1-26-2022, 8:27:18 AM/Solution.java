// https://leetcode.com/problems/kth-missing-positive-number

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start +  (end - start) / 2;
            if (arr[mid] - mid - 1 < k) // eg [2, 5] ind [0 , 1] k = 1 =? 2 - 0 - 1 !< 1 so break look
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start + k;
    }
}