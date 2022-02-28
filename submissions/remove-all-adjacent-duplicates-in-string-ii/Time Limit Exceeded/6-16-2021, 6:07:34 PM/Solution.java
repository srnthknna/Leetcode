// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii

class Solution {
    public String removeDuplicates(String s, int k) {
        String temp = "", curr = s;
        while (!temp.equals(curr)) {
            temp = curr;
            curr = removeDuplicates(k, curr);
        }
        return curr;
    }
    
    public String removeDuplicates(int k, String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0, lastCounter = k;
        int ind = 0;
        for (char c : S.toCharArray()) {
            if (sbLength != 0 && c == sb.charAt(sbLength - 1)) {
                if (lastCounter < k) {
                    sb.append(c);
                    sbLength++;
                    lastCounter--;
                } 
                if (lastCounter == 0) {
                    for (int i = 0; i < k; i++) {
                        sb.deleteCharAt(sbLength - 1);
                        sbLength--;
                    }
                }
            } else {
                sb.append(c);
                sbLength++;
                lastCounter = k - 1;
            }
        }
        return sb.toString();
    }
}