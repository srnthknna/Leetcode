// https://leetcode.com/problems/slowest-key

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char slowc = keysPressed.charAt(0);
        int slowd = releaseTimes[0];
        
        for (int i = 1; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);
            if (slowd < duration) {
                slowd = duration;
                slowc = c;
            }
            if (slowd == duration) {
                slowc = slowc > c ? slowc : c;
            }
        }
        return slowc;
    }
}