// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) result++;
        }
        return result;
    }
}