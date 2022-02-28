// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work

class Solution {
    public long numberOfWeeks(int[] milestones) {
        int sum = 0, max = 0;
        for (int i : milestones) {
            sum += i;
            max = Math.max(max, i);
        }
        return Math.min(sum, 2 * (sum - max) + 1);
    }
}