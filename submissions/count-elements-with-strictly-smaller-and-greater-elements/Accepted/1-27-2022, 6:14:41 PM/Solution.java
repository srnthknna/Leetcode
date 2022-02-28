// https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements

class Solution {
    public int countElements(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt(), max = Arrays.stream(nums).max().getAsInt();
        return (int) Arrays.stream(nums).filter(n -> min < n && n < max).count();
    }
}