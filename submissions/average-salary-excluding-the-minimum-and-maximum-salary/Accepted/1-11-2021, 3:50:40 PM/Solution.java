// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double sum = 0;
        for (int i : salary) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            sum += i;
        }
        return (sum - max - min) / (salary.length - 2);
    }
}