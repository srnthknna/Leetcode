// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lllCount = 0;
        if (s.charAt(0) == 'A') {
            absentCount++;
        }
        if (s.length() > 1 && s.charAt(0) == 'A') {
            absentCount++;
        }
        if (s.length() > 1 && s.charAt(0) == 'L' && s.charAt(1) == 'L') {
            lllCount++;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
            } else if (s.charAt(i) == 'L' && s.charAt(i - 1) == 'L') {
                lllCount++;
            }
        }
        if (absentCount <= 1 && lllCount <= 1) {
            return true;
        } else {
            return false;
        }
    }
}