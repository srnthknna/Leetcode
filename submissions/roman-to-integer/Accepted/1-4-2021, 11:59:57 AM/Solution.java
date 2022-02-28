// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M': res += 1000; break;
                case 'D': res += 500; break;
                case 'C': res += 100 * (res >= 500 ? -1 : 1); break; //CD CM
                case 'L': res += 50; break;
                case 'X': res += 10 * (res >= 50 ? -1 : 1); break; // XL XC
                case 'V': res += 5; break;
                case 'I': res += 1 * (res >= 5 ? -1 : 1); break; // IV IX
                default: break;
            }
        }
        return res;
    }
}