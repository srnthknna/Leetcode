// https://leetcode.com/problems/longest-happy-string

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int size = a + b + c;
        int A = 0, B = 0, C = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if ((a >= b && a >= c && A != 2) || (B == 2 && a > 0) || (C == 2 && a > 0)) {
                B = 0;
                C = 0;
                sb.append("a");
                A++;
                a--;
            } else if ((b >= c && b >= a && B != 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                B = 0;
                C = 0;
                sb.append("b");
                b--;
                B++;
            } else if ((c >= a && c >= b && C != 2) || (A == 2 && c > 0) || (B == 2 && c > 0)) {
                B = 0;
                A = 0;
                sb.append("c");
                C++;
                c--;
            }
        }
        return sb.toString();
    }
}