// https://leetcode.com/problems/number-of-atoms

class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        
        for (int i = 0; i < n;) {
            char first = formula.charAt(i);
            if (first == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (first == ')') {
                Map<String, Integer> top = stack.pop();
                int istart = ++i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = istart < i ? Integer.parseInt(formula.substring(istart, i)) : 1;
                
                for (String chemical : top.keySet()) {
                    int value = top.get(chemical);
                    stack.peek().put(chemical, stack.peek().getOrDefault(chemical, 0) + value * multiplicity);
                }
            } else {
                int istart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String chemical = formula.substring(istart, i);
                istart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = istart < i ? Integer.parseInt(formula.substring(istart, i)) : 1;
                
                stack.peek().put(chemical, stack.peek().getOrDefault(chemical, 0) + multiplicity);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String chemical : stack.peek().keySet()) {
            sb.append(chemical);
            if (stack.peek().get(chemical) > 1) {
                sb.append("" + stack.peek().get(chemical));
            }
        }
        return sb.toString();
    }
}