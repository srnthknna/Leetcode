// https://leetcode.com/problems/clone-graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        Map<Node, Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        
        visited.put(node, new Node(node.val));
        queue.add(node);
        
        while (!queue.isEmpty()) {
            Node cur = queue.remove();       
            for (Node neighbor : cur.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, (new Node(neighbor.val)));
                    queue.add(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
    }
}