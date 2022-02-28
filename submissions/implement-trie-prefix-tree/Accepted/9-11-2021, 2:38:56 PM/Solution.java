// https://leetcode.com/problems/implement-trie-prefix-tree

class Trie {
    
    class TrieNode {
        Map<Character, TrieNode> childs;
        boolean isEnd;
        
        public TrieNode() {
            childs = new HashMap<>();
            isEnd = false;
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.childs.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.childs.put(ch, node);
            }
            current = node;
        }
        current.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.childs.get(ch);
            if (node == null)
                return false;
            current = node;
        }
        return current.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = current.childs.get(ch);
            if (node == null)
                return false;
            current = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */