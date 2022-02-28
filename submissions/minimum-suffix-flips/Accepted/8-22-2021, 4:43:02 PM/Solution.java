// https://leetcode.com/problems/minimum-suffix-flips

class Solution {
    public int minFlips(String target) {
        char prev = '0';
        int count = 0;
        
        for (char c : target.toCharArray()) {
            if (prev != c) {
                count++;
                prev= c;
            }
        }
        return count;
    }
}