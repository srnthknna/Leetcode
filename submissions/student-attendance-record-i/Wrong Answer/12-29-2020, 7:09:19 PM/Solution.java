// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int llCount = 0;
        if (s.charAt(0) == 'A') {
            absentCount++;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == 'L' && s.charAt(i) == 'L') {
                llCount++;
            }
        }
        if (absentCount <= 1 || llCount < 1) {
            return true;
        } else {
            return false;
        }
    }
}