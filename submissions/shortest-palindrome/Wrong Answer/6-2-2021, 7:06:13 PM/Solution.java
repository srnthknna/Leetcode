// https://leetcode.com/problems/shortest-palindrome

class Solution {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder().append(s).reverse().toString();
        int sind = 0;
        int rind = 0;
        if (s.equals(r)) return s;
        //System.out.println(r);
        while (sind <= r.length() - 1 && rind <= r.length() - 1) {
            if (s.charAt(sind) != r.charAt(rind)) {
                rind++;
            } else {
                break;
            }
        }
        //System.out.println(sind + " " + rind);
        //System.out.println(r.substring(0, rind + 1));
        return (rind == 0 ? r.substring(0, rind + 1) : r.substring(0, rind)) + s;
    }
}