// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int length = s.length() % k == 0 ? s.length() / k : s.length() / k + 1;
        String[] result = new String[length];

        
        int curr = 0, n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length * k; i++) {
            sb.append(i < n ? s.charAt(i) : fill);
            if ((i + 1) % k == 0) {
                result[curr++] = sb.toString();
                sb = new StringBuilder();
            }
        }
        return result;
    }
}