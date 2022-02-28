// https://leetcode.com/problems/strobogrammatic-number

class Solution {
    public boolean isStrobogrammatic(String num) {
       char[] rotatedDigits = new char[]{'0', '1', '\0', '\0', '\0', '\0', '9', '\0', '8', '6'};
        
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            sb.append(rotatedDigits[Character.getNumericValue(num.charAt(i))]);
        }
        
        return num.equals(sb.toString());
    }
}