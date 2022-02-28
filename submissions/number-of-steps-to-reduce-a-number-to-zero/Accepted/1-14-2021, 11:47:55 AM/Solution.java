// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero

class Solution {
    public int numberOfSteps (int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
        //Bit solution
        // String binS = Integer.toBinaryString(num);
        // System.out.println(binS);
        // for (char bit : binS.toCharArray()) {
        //     if (bit == '1') steps+=2;
        //     else steps++;
        // }
        // return --steps;
    }
}