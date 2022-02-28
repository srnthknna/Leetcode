// https://leetcode.com/problems/repeated-string-match

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder as = new StringBuilder();
        as.append(a);
        for (int rep = 1; rep <= b.length() / a.length() + 2; rep++) {
            if (as.toString().indexOf(b) != -1) return rep;
            as.append(a);
        }
        return -1;
    }
}