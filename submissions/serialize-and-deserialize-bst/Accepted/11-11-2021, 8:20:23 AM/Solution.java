// https://leetcode.com/problems/serialize-and-deserialize-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private StringBuilder postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return sb;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(" ");
        return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb = postOrder(root, sb);
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    
    private TreeNode helper(int min, int max, ArrayDeque<Integer> arr) {
        if (arr.isEmpty()) return null;
        int num = arr.getLast();
        
        if (num < min || num > max) {
            return null;
        }
        
        arr.removeLast();
        
        TreeNode root = new TreeNode(num);
        root.right = helper(num, max, arr);
        root.left = helper(min, num, arr);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for (String s : data.split("\\s+")) {
            arr.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;