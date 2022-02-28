// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;
        
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }
        
        int pivot, num;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = reader.get(pivot);
            if (num == target) return pivot;
            else if (num > target) 
                right = pivot - 1;
            else
                left = pivot + 1;
        }
        return -1;
    }
}