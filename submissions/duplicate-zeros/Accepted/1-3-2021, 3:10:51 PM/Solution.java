// https://leetcode.com/problems/duplicate-zeros

class Solution {
    public void duplicateZeros(int[] arr) {
        int zero = 0;
        for (int n : arr) if (n == 0) zero++;
        
        int i = arr.length - 1, j = arr.length + zero - 1;
        while (i != j) {
            insert(arr, i, j--);
            if (arr[i] == 0) insert(arr, i, j--);
            i--;
        }
    }
    
    private void insert(int[] arr, int i, int j) {
        if (j < arr.length) {
            arr[j] = arr[i];
        }
    }
}