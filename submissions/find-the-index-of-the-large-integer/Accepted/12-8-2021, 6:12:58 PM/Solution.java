// https://leetcode.com/problems/find-the-index-of-the-large-integer

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0, right = reader.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res;
            if ((right - left) % 2 == 1) {
                res = reader.compareSub(left, mid, mid + 1, right);
            } else {
                res = reader.compareSub(left, mid, mid, right);
            }
            
            if (res == 0) return mid;
            else if (res == 1) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}