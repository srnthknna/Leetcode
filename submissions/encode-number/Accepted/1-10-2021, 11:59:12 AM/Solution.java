// https://leetcode.com/problems/encode-number

class Solution {
    public String encode(int num) {
        char[] chars = new char[] {'1', '0'};
        StringBuilder stb = new StringBuilder();
        while(num > 0) {
            stb.append(chars[num % 2]);
            num = (num - 1) / 2;
        }
        return stb.reverse().toString(); 
    }
}