// https://leetcode.com/problems/sort-an-array

class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private int partision(int[] nums, int low, int high) {
        int pivot = nums[high];
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than the pivot
            if (nums[j] < pivot) {
                // Increment index of
                // smaller element
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return (i + 1);
    }
    
    private void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partision(nums, low, high);
            quicksort(nums, low, pivot - 1);
            quicksort(nums, pivot + 1, high);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}