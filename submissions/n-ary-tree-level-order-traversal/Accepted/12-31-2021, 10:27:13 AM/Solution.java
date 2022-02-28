// https://leetcode.com/problems/n-ary-tree-level-order-traversal

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<Node> curr = new ArrayList<>(), next;
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> row;
        
        if (root == null) return output;
        curr.add(root);
        
        while(!curr.isEmpty()) {
            next = new ArrayList<>();
            row = new ArrayList<>();
            for (Node n : curr) {
                row.add(n.val);
                if (n.children != null)
                   next.addAll(n.children);
            }
            output.add(row);
            
            curr = next;
        }
        
        return output; 
    }
}