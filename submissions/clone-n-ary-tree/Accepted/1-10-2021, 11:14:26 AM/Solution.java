// https://leetcode.com/problems/clone-n-ary-tree

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
    public Node cloneTree(Node root) {
        // sanity check
        if(root == null) return root;
        
        Map<Node, Node> map = new HashMap<>();
        map.put(root, new Node(root.val));
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            
            for(Node next : cur.children){
                if(!map.containsKey(next)){
                    map.put(next, new Node(next.val));
                    stack.push(next);
                }
                
                map.get(cur).children.add(map.get(next));
            }
        }
        
        return map.get(root);
    }
}