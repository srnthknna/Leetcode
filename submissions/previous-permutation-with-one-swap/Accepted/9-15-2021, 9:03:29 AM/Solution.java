// https://leetcode.com/problems/previous-permutation-with-one-swap

class Solution {
    public int[] prevPermOpt1(int[] arr) {
        if (arr.length < 2) return arr;
        
        int transPos = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i-1]) {
                transPos = i - 1;
                break;
            }
        }

        if (transPos == -1) return arr;
        
        int maxTrans = transPos + 1;
        
        for (int i = transPos + 1; i < arr.length; i++) {
            if (arr[i] >= arr[transPos]) {
                break;
            }
            if (arr[maxTrans] < arr[i]) {
                maxTrans = i;
            }
        }
        
        swap(arr, transPos, maxTrans);
        
        return arr;
    }
    
    public void swap(int[] arr, int transitionPos, int maxPos) {
        int temp = arr[transitionPos];
        arr[transitionPos] = arr[maxPos];
        arr[maxPos] = temp;   
    }
}