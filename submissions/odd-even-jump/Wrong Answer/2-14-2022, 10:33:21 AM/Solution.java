// https://leetcode.com/problems/odd-even-jump

class Solution {

    int[] firstSmallerToRight;
    int[] firstLargerToRight;
    public int oddEvenJumps(int[] arr) {
        firstSmallerToRight = new int[arr.length];
        firstLargerToRight = new int[arr.length];
        Arrays.fill(firstLargerToRight, -1);
        Arrays.fill(firstSmallerToRight, -1);
        buildIncreasingStack(arr);
        buildDecreasingStack(arr);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (canJump(1, i, arr)) {
                ans++;
            }
        }
        return ans;
    }
    
    private void buildIncreasingStack(int[] arr) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                firstSmallerToRight[stack.pop()] = i;
            }
            stack.push(i);
        }
    }

    private void buildDecreasingStack(int[] arr) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                firstLargerToRight[stack.pop()] = i;
            }
            stack.push(i);
        }
    }
    
    private boolean canJump(int jumpCount, int currIndex, int[] arr) {
        if (currIndex == arr.length - 1) return true;
        if (jumpCount % 2 == 1) {
            int nextIndex = firstLargerToRight[currIndex];
            
            if (nextIndex != -1) {
                return canJump(jumpCount + 1, nextIndex, arr);
            }
        } else {
            int nextIndex = firstSmallerToRight[currIndex];
            if (nextIndex != -1) {
                return canJump(jumpCount + 1, nextIndex, arr);
            }
        }
        return false;
    }
    
    private int canOddJump(int currIndex, int[] arr) {
        int ans = -1, nextIndex = -1;
        for (int j = currIndex + 1; j < arr.length; j++) {
            if (arr[currIndex] <= arr[j] && (ans == -1 || ans > arr[j])) {
                ans = arr[j];
                nextIndex = j;
            }
        }
        return nextIndex;
    }
    
    private int canEvenJump(int currIndex, int[] arr) {
        int ans = -1, nextIndex = -1;
        for (int j = currIndex + 1; j < arr.length; j++) {
            if (arr[currIndex] >= arr[j] && (ans == -1 || ans < arr[j])) {
                ans = arr[j];
                nextIndex = j;
            }
        }
        return nextIndex;
    }
}