// https://leetcode.com/problems/different-ways-to-add-parentheses

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char op = expression.charAt(i);
            if (op == '-' || op == '*' || op== '+') {
                List<Integer> aVals = diffWaysToCompute(expression.substring(0, i));
                List<Integer> bVals = diffWaysToCompute(expression.substring(i + 1));
                for (int aVal : aVals) {
                    for (int bVal : bVals) {
                        switch (op) {
                            case '+': result.add(aVal + bVal);
                                break;
                            case '-': result.add(aVal - bVal);
                                break;
                            case '*': result.add(aVal * bVal);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(expression));
        }
        return result;
    }
}