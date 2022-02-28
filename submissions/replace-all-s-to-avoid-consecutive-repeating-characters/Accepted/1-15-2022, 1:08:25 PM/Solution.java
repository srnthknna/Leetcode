// https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters

class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '?') {
                for (arr[i] = 'a'; arr[i] <= 'c'; arr[i]++) {
                    if ((i == 0 || (arr[i - 1] != arr[i])) && (i == s.length() - 1 || (arr[i + 1] != arr[i])))
                        break;
                }
            }
        }
        return new String(arr);
    }
}