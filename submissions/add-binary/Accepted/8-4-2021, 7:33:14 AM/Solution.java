// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String as, String bs) {
        StringBuilder sb = new StringBuilder();
        int i = as.length() - 1, j = bs.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int a = Integer.parseInt(as.charAt(i) + "");
            int b = Integer.parseInt(bs.charAt(j) + "");
            int sum = a + b + carry;
            if (sum == 0 || sum == 1) {
                carry = 0;
                sb.append(sum);
            } else if (sum == 2) {
                carry = 1;
                sb.append(0);
            } else if (sum == 3) {
                carry = 1;
                sb.append(1);
            }
            i--;
            j--;
        }
        if (i != j) {
            String remaining = i < 0 ? bs : as;
            int index = i < 0 ? j : i;
            while (index >= 0) {
                int a = Integer.parseInt(remaining.charAt(index) + "");
                int sum = a + carry;
                if (sum == 0 || sum == 1) {
                    carry = 0;
                    sb.append(sum);
                } else if (sum == 2) {
                    carry = 1;
                    sb.append(0);
                }
                index--;
            }
        }
        if (carry != 0)
            sb.append(carry);
        sb.reverse();
        return sb.toString();
    }
}