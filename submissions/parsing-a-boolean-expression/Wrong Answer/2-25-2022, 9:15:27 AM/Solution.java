// https://leetcode.com/problems/parsing-a-boolean-expression

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            switch (c) {
                case '&':
                case '|':
                case '!':
                case 't':
                case 'f':
                    stack.push(c);
                    break;
                case '(':
                case ',':
                    break;
                case ')':
                    evaluate(stack);
            }
        }
        while (stack.size() != 1) {
            evaluate(stack);
        }
        return stack.pop() == 't' ? true : false;
    }
    
    private void evaluate(Stack<Character> stack) {
        List<Boolean> vars = new ArrayList<>();
        char top;
        do {
            top = stack.pop();
            switch(top) {
                case 't':
                    vars.add(true);
                    break;
                case 'f':
                    vars.add(false);
                    break;
                case '&':
                    boolean and = true;
                    for (boolean var : vars)
                        and &= var;
                    stack.push(and == true ? 't' : 'f');
                    break;
                case '|':
                    boolean or = true;
                    for (boolean var : vars)
                        or |= var;
                    stack.push(or == true ? 't' : 'f');
                    break;
                case '!':
                    boolean not = vars.get(0);
                    not = not == true ? false : true;
                    stack.push(not == true ? 't' : 'f');
                    break;
            }
        } while (top != '&' && top != '|' && top != '!');
    }
}