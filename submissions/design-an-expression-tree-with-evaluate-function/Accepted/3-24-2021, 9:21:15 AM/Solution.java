// https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Integer> stack = new Stack<>();
        for(String i: postfix) {
            if(i.equals("+")) stack.push(stack.pop() + stack.pop());
            else if(i.equals("-")) {
                stack.push( - stack.pop() + stack.pop());
            } else if(i.equals("*")) stack.push(stack.pop() * stack.pop());
            else if(i.equals("/")) {
                int previous = stack.pop();
                stack.push(stack.pop() / previous);
            } else stack.push(Integer.parseInt(i));
        }
        return new Node() {
            public int evaluate() {
                return stack.pop();
            }
        };
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */