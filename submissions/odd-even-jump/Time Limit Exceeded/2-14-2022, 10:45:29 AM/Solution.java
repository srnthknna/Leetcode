// https://leetcode.com/problems/odd-even-jump

class Solution {

    Map<Integer, Integer> canOddJumpFact = new HashMap<>();
    Map<Integer, Integer> canEvenJumpFact = new HashMap<>();
    public int oddEvenJumps(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (canJump(1, i, arr)) {
                ans++;
            }
        }
        return ans;
    }
    
    private boolean canJump(int jumpCount, int currIndex, int[] arr) {
        if (currIndex == arr.length - 1) return true;
        if (jumpCount % 2 == 1) {
            int nextIndex = canOddJump(currIndex, arr);
            
            if (nextIndex != -1) {
                return canJump(jumpCount + 1, nextIndex, arr);
            }
        } else {
            int nextIndex = canEvenJump(currIndex, arr);
            if (nextIndex != -1) {
                return canJump(jumpCount + 1, nextIndex, arr);
            }
        }
        return false;
    }
    
    private int canOddJump(int currIndex, int[] arr) {
        if (canEvenJumpFact.containsKey(currIndex)) {
            return canEvenJumpFact.get(currIndex);
        }
        int ans = -1, nextIndex = -1;
        for (int j = currIndex + 1; j < arr.length; j++) {
            if (arr[currIndex] <= arr[j] && (ans == -1 || ans > arr[j])) {
                ans = arr[j];
                nextIndex = j;
            }
        }
        canEvenJumpFact.put(currIndex, nextIndex);
        return nextIndex;
    }
    
    private int canEvenJump(int currIndex, int[] arr) {
        if (canOddJumpFact.containsKey(currIndex)) {
            return canOddJumpFact.get(currIndex);
        }
        int ans = -1, nextIndex = -1;
        for (int j = currIndex + 1; j < arr.length; j++) {
            if (arr[currIndex] >= arr[j] && (ans == -1 || ans < arr[j])) {
                ans = arr[j];
                nextIndex = j;
            }
        }
        canOddJumpFact.put(currIndex, nextIndex);
        return nextIndex;
    }
}