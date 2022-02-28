// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Arrays.sort(target);
        // Arrays.sort(arr);
        // return Arrays.equals(target, arr);
        int start1 = target.length - 1;
        int start2 = arr.length - 1;
        while (start1 > 0 && start2 > 0) {
            if (target[start1] == arr[start2]) {
                start1--;
                start2--;
            } else {
                int idx = start2;
                while (idx >=0 && arr[idx] != target[start1]) idx--;
                if (idx == -1) return false;
                swap(arr, start2, idx);
            }
        }
        return true;
    }
    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}