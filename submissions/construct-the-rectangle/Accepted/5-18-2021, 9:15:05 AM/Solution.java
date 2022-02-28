// https://leetcode.com/problems/construct-the-rectangle

class Solution {
    public int[] constructRectangle(int area) {
        if (area < 3) return new int[] {area, 1};
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt-- != 0);
        return new int[] {area/++sqrt, sqrt};
    }
}