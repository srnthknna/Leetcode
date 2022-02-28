// https://leetcode.com/problems/minimum-suffix-flips

class Solution {
    public int minFlips(String target) {
        char prev = '0';
        int count = 0;
        
        for (int i = 0; i < target.length(); i++) {
            if (prev != target.charAt(i)) {
                count++;
                prev= target.charAt(i);
            }
        }
        return count;
    }
}