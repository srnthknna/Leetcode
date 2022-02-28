// https://leetcode.com/problems/find-root-of-n-ary-tree

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        Set<Node> children = new HashSet<>();
        for (Node node : tree)
            for (Node child : node.children)
                if (!children.contains(child))
                    children.add(child);
        Node root = null;
        for (Node node : tree)
            if (!children.contains(node)) {
                root = node;
                break;
            }
        return root;
    }
}