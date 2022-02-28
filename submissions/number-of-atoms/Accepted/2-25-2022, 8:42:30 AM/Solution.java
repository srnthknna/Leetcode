// https://leetcode.com/problems/number-of-atoms

class Solution {
    //https://leetcode.com/problems/find-right-interval/solution/
    // Basically three cases
    // use stack with a treemap to keep the coumpounds in sorted order
    // when you encounter the opening braces then create a new map and push it analyze the current compound structure
    // when you encounter the closing braces then you see if there is a number that follows then in that case you need to multiply all the current compound structure chemical elements with the number else just add them as is
    // when you encounter any other character, in that case either it is a number or a lowe case letter
    // lower case letter is the follow of the element
    // digit is the multiplicity of the element 
    // add the element to the map
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