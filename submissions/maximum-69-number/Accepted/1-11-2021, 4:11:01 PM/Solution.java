// https://leetcode.com/problems/maximum-69-number

class Solution {
    public int maximum69Number (int num) {
        int temp = num;
        int index = -1;

        for(int i = 0; temp > 0; i++) {
            if(temp % 10 == 6) {
                index = i;
            }
            temp = temp / 10;
        }

        return index == -1 ? num : num +  3 * (int)Math.pow(10, index);
    }
}