// https://leetcode.com/problems/minimum-number-of-frogs-croaking

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int frog = 0, maxFrog = 0;
        int[] count = new int[5];
        
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            int ch = croakOfFrogs.charAt(i);
            int index = "croak".indexOf(ch);
            count[index]++;
            if (index == 0) {
                maxFrog = Math.max(maxFrog, ++frog);
            } else if (--count[index - 1] < 0) {
                return -1;
            } else if (index == 4) {
                --frog;
            }
        }
        return frog == 0 ? maxFrog : -1;
    }
}