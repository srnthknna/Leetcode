// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        int count = 0;
        for (char a : s.toCharArray()) {
            if (a == 'A') count++;
        }
        return count < 2 && s.indexOf("LLL") < 0;
    }
}