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
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
            } else if (s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
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