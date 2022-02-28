// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int length = s.length() % k == 0 ? s.length() / k : s.length() / k + 1;
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            result[i] = "";
        }
        
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            result[curr] += s.charAt(i);
            if (result[curr].length() == k) {
                curr++;
            }
        }
        if (curr < length) {
            for (int i = result[curr].length(); i < k; i++) {
                result[curr] += fill;
            }
        }
        return result;
    }
}