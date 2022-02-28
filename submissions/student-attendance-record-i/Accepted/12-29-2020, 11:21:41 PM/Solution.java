// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        return !s.matches(".*(A.*A|LLL).*");
    }
}