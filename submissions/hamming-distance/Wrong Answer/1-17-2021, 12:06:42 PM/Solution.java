// https://leetcode.com/problems/hamming-distance

class Solution {
    public int hammingDistance(int x, int y) {
        String xBit = Integer.toBinaryString(x);
        String yBit = Integer.toBinaryString(y);
        int count = 0;
        for (int i = 0; i < Math.min(xBit.length(), yBit.length()); i++) {
            if (xBit.charAt(i) != yBit.charAt(i)) count++;
        }
        
        if (xBit.length() > yBit.length()) count += xBit.length() - yBit.length();
        else count += yBit.length() - xBit.length();
        return count;
    }
}