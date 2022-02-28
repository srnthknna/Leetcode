// https://leetcode.com/problems/maximum-depth-of-n-ary-tree

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
    int maxDepth = 0;
    public int maxDepth(Node root) {
        maxDepthHelper(root, 0);
        return maxDepth;
    }
    
    private void maxDepthHelper(Node root, int depth) {
        if (root == null) return;
        depth++;
        maxDepth = Math.max(depth, maxDepth);
        for (Node c : root.children) {
            maxDepthHelper(c, depth);
        }
    }
}