// https://leetcode.com/problems/fibonacci-number

class Solution {
    public int fib(int n) {
        return (int) ((Math.pow(1 + Math.sqrt(5), n) - Math.pow(1 - Math.sqrt(5), n)) /
        (Math.pow(2, n) * Math.sqrt(5)));
    }
}