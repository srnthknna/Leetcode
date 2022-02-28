// https://leetcode.com/problems/fizz-buzz

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder sb;
        for (int i = 1; i <= n; i++) {
            sb = new StringBuilder();
            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");
            if (sb.length() == 0) sb.append(i);
            results.add(sb.toString());
        }
        return results;
    }
}